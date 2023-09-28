package com.savchuk.booklistapptask.data.local

import com.savchuk.booklistapptask.data.BooKCategoryDataModel
import com.savchuk.booklistapptask.data.local.entity.BookCategoryEntity
import com.savchuk.booklistapptask.domain.Mapper
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class LocalBookDataSourceTest {

    @Test
    fun `insert Book category correctly`() = runBlocking {
        val dao = TestDao()
        val mapper = TestMapper()

        val dataSource = LocalBookDataSource.Base(dao, mapper)

        dataSource.insertBookCategories(
            listOf(
                BooKCategoryDataModel(
                    "test",
                    "test_new",
                    "test_old",
                    "test_updated"
                )
            )
        )

        val expected = BooKCategoryDataModel(
            "test",
            "test_new",
            "test_old",
            "test_updated"
        )
        assertEquals(expected, mapper.map(dao.data[0]))
    }

    @Test
    fun `return list of book category correctly`() = runBlocking {
        val dao = TestDao()
        val mapper = TestMapper()

        val dataSource = LocalBookDataSource.Base(dao, mapper)
        dao.data.add(
            BookCategoryEntity(
                name = "test",
                newestPublishedDate = "test_new",
                oldestPublishedDate = "test_old",
                updated = "test_updated"
            )
        )
        val actual = dataSource.getBookCategory()

        val expected = listOf(
            BooKCategoryDataModel(
                "test",
                "test_new",
                "test_old",
                "test_updated"
            )
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `delete all categories`() = runBlocking {
        val dao = TestDao()
        val mapper = TestMapper()
        val dataSource = LocalBookDataSource.Base(dao, mapper)
        val list = listOf(
            BooKCategoryDataModel(
                "test",
                "test_new",
                "test_old",
                "test_updated"
            )
        )
        dao.data.addAll(
            listOf(
                BookCategoryEntity(
                    name = "test",
                    newestPublishedDate = "test_new",
                    oldestPublishedDate = "test_old",
                    updated = "test_updated"
                )
            )
        )
        dataSource.deleteAllCategory(list)
        val actual = dao.data.map { mapper.map(it) }
        assertEquals(emptyList<BooKCategoryDataModel>(), actual)
    }

    @Test
    fun `get empty book category list`() = runBlocking{
        val dao = TestDao()
        val mapper = TestMapper()
        val dataSource = LocalBookDataSource.Base(dao, mapper)
        val actual = dataSource.getBookCategory()
        assertEquals(emptyList<BooKCategoryDataModel>(), actual)
    }

    class TestDao : BookDao {
        val data = mutableListOf<BookCategoryEntity>()

        override suspend fun getBooksCategories(): List<BookCategoryEntity> {
            return data
        }

        override suspend fun insertBooksCategories(list: List<BookCategoryEntity>) {
            data.addAll(list)
        }

        override suspend fun deleteAllCategory(list: List<BookCategoryEntity>) {
            data.removeAll(list)
        }
    }

    class TestMapper : Mapper<BookCategoryEntity, BooKCategoryDataModel> {
        override fun map(data: BookCategoryEntity): BooKCategoryDataModel {
            return BooKCategoryDataModel(
                name = data.name,
                newestPublishedDate = data.newestPublishedDate,
                oldestPublishedDate = data.oldestPublishedDate,
                updated = data.updated
            )
        }

    }
}