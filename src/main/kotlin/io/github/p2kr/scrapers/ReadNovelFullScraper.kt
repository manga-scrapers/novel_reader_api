package io.github.p2kr.scrapers

import io.github.p2kr.models.SearchBook
import io.ktor.http.*
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.slf4j.LoggerFactory
import java.time.Duration


object ReadNovelFullScraper : GenericScraper {
    private const val BASE_URL = "https://readnovelfull.com"
    private val LOG = LoggerFactory.getLogger(ReadNovelFullScraper.javaClass)
    private const val KEYWORD = "keyword"
    override fun getSearchBooksList(query: Parameters): List<SearchBook> {
        val listOfSearchBook = arrayListOf<SearchBook>()
        if (!query.contains(KEYWORD)) {
            LOG.error("No keyword")
            return listOfSearchBook
        }
        LOG.debug("Keyword: " + query[KEYWORD])

        val options = ChromeOptions()
        val driver = ChromeDriver(options)

        driver.get(BASE_URL)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15))

        //////////////////////
        // Do scraping here //
        /////////////////////

        driver.manage().window().maximize()
        val textField = driver.findElement(By.id("search-input"))
        textField.sendKeys(query["keyword"])
        textField.sendKeys(Keys.ENTER)


        // Find all books
        var pageCount = 1
        do {
            val bookTitles =
                driver.findElements(By.xpath("""//div[@class="row"]//h3[@class="novel-title"]//a"""))
                    .map { it.getAttribute("title").trim() }

            val authors =
                driver.findElements(By.xpath("""//div[@class="row"]//span[@class="author"]""")).map { it.text.trim() }

            val thumbnailLinks =
                driver.findElements(By.xpath("""//div[@class="row"]//img[@class="cover"]"""))
                    .map { it.getAttribute("src") }

            val bookLinks = driver.findElements(By.xpath("""//div[@class="row"]//h3[@class="novel-title"]//a"""))
                .map { it.getAttribute("href") }


            for (i in bookTitles.indices) {
                val searchBook = SearchBook()
                searchBook.name = bookTitles[i]
                searchBook.author = authors[i]
                searchBook.thumbnailLink = thumbnailLinks[i]
                searchBook.bookLink = bookLinks[i]

                listOfSearchBook.add(searchBook)
            }
            LOG.debug("Length of search book for $pageCount page = " + bookTitles.size)

            // check for next button
            try {
                driver.manage().timeouts().implicitlyWait(Duration.ZERO)
                val nextBtn =
                    driver.findElement(By.xpath("""//ul[contains(@class, "pagination")]//li[@class="next"]//a"""))

                nextBtn.click()
            } catch (e: NoSuchElementException) {
                break
            } finally {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15))
            }
            pageCount++
        } while (true)
        /////////////////////
        // Close resources //
        /////////////////////
        driver.quit()
        LOG.debug("Total length ($pageCount pages) of search results = " + listOfSearchBook.size)
        return listOfSearchBook
    }
}
