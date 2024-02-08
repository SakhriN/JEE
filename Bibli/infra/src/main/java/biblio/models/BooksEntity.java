package biblio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "books")
public class BooksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name_book, description_book;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_book() {
        return name_book;
    }

    public void setName_book(String name_book) {
        this.name_book = name_book;
    }

    public String getDescription_book() {
        return description_book;
    }

    public void setDescription_book(String description_book) {
        this.description_book = description_book;
    }

    public BooksEntity() {
    }

    public BooksEntity(String name_book, String description_book) {
        this.name_book = name_book;
        this.description_book = description_book;
    }

    public BooksEntity(int id, String name_book, String description_book) {
        this.id = id;
        this.name_book = name_book;
        this.description_book = description_book;
    }

    @Override
    public String toString() {
        return "Books : " +
                "id = " + id +
                ", name_book = " + name_book +
                ", description_book='" + description_book +
                ". ";
    }


    public static class Builder {
        int id;
        String name_book, description_book;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name_book(String name_book) {
            this.name_book = name_book;
            return this;
        }

        public Builder description_book(String description_book) {
            this.description_book = description_book;
            return this;
        }


        public BooksEntity build() {
            BooksEntity booksEntity = new BooksEntity();
            booksEntity.id = this.id;
            booksEntity.description_book = this.description_book;
            booksEntity.name_book = this.name_book;
            return booksEntity;
        }
    }
    public Books toBook() {
        return new Books.Builder().name_book(name_book).id(id).description_book(description_book).build();
    }
}

