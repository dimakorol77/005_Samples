package ex_001_select_and_insert;

import ex_001_select_and_insert.entity.Author;
import org.jboss.logging.Logger;

import java.util.List;

public class Main {

    private static final Logger LOG = Logger.getLogger(AuthorHelper.class.getName());

    public static void main(String[] args) {
        AuthorHelper ah = new AuthorHelper();

        Author[] authors = {new Author("Laitman"), new Author("Sulam"), new Author("Moshe")};

        for (Author author : authors) {
            ah.addAuthor(author);
        }

        List<Author> authorList = ah.getAuthorList();
        for (Author author : authorList){
            System.out.println(author.getId() + " " +author.getName());
        }

        Author author = new Author("Pushkin");
        ah.addAuthor(author);
        System.out.println(author.getId() + " " +author.getName());

        // Обновление автора
        Author authorToUpdate = ah.getAuthorById(3);
        authorToUpdate.setName("Tolstoy");
        ah.updateAuthor(authorToUpdate);

        // Удаление автора
        Author authorToDelete = ah.getAuthorById(2);
        ah.deleteAuthor(authorToDelete);

        authorList = ah.getAuthorList();
        for (Author a : authorList) {
            LOG.debug(a.getId() + " " + a.getName());
        }
    }
}
