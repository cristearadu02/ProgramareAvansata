package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            var artists = new ArtistDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");
            var genres = new GenreDAO();
            genres.create("Rock");
            //TODO: Funk, Soul, Pop
            genres.create("Funk");
            genres.create("Soul");
            genres.create("Pop");
            Database.getConnection().commit();
            var albums = new AlbumDAO();
            //albums.create(1979, "The Wall", "Pink Floyd", "Rock");
            System.out.println("Find by id: ");
            System.out.println(albums.findById(1));
            //findByName
            //albums.create(1982, "Thriller", "Michael Jackson","Funk,Soul,Pop");
            Database.getConnection().commit();
            System.out.println("Print all: ");
            //TODO: print all the albums in the database
            albums.printAllAlbums();
            Database.getConnection().close();
        } catch (SQLException e)
        {
            System.err.println(e);
            try {
                Database.getConnection().rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}