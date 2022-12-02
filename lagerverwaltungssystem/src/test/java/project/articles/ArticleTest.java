package project.articles;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Test class for project.articles.Article
 * @author Ruf, Lukas
 */
public class ArticleTest {
    private Article a;

    @BeforeEach
    void startUp() {
        a = new Article();
    }

    @AfterEach
    void tearDown() { Article.getarticleList().clear(); }

    @Test
    void testArticleConstructor(){
        Assertions.assertNull(a.getId());
        Assertions.assertNull(a.getName());
        Assertions.assertEquals(0, a.getType());
        Assertions.assertEquals(0, Article.getNumArticles());
        Assertions.assertTrue(Article.getarticleList() instanceof ArrayList<Article>);
        Assertions.assertTrue(Article.getarticleList().isEmpty());
    }

    @Test
    void testArticleAttrSet(){
        a.setId("k");
        a.setName("test");
        a.setType(32);
        Assertions.assertEquals("k", a.getId());
        Assertions.assertEquals("test", a.getName());
        Assertions.assertEquals(32, a.getType());
        Assertions.assertFalse(a.getAvailability());
    }

    @Test
    void testArticletoString() {
        a.setId("f");
        a.setName("test");
        a.setType(64);
        Assertions.assertEquals("64 test f false", a.toString());
    }

    @Test
    void testArticleprintException() {
        Article.getarticleList().clear();
        Assertions.assertThrows(IllegalStateException.class, () -> {
           Article.printArticles();
        });
    }

    @Test
    void testArticleList() {
        Article.getarticleList().add(a); // TODO: add a custom method for this
        Assertions.assertEquals(1, Article.getarticleList().size());
    }
}
