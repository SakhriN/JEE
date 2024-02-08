package biblio.models;

public class Books {
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

    public Books() {
    }

    public Books(String name_book, String description_book) {
        this.name_book = name_book;
        this.description_book = description_book;
    }

    public Books(int id, String name_book, String description_book) {
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


        public Books build() {
            Books books = new Books();
            books.id = this.id;
            books.description_book = this.description_book;
            books.name_book = this.name_book;
            return books;
        }
    }



}
