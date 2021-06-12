package com.practice.leetcode.tcsdigital.active;

import java.util.*;
import java.util.stream.Collectors;

public class MyClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Song> songs = new ArrayList<>();

        for(int i=0; i<5; i++){
            int songId = sc.nextInt();
            sc.nextLine();
            String title = sc.nextLine();
            String artist = sc.nextLine();
            double duration = sc.nextDouble();

            songs.add(new Song(songId, title, artist, duration));
        }

        sc.nextLine();
        String artist1 = sc.nextLine();
        String artist2 = sc.nextLine();


        double sum = findSongDurationForArtist(songs, artist1);

        if(sum == 0)
            System.out.println("There are no songs with given artist");
        else
            System.out.println(sum);

        List<Song> songList = getSongsInAscendingOrder(songs, artist2);
        if(songList.size() == 0) {
            System.out.println("There are no songs with given artist");
        } else {
            for(int i = 0; i< songList.size()-1; i++){
                System.out.println(songList.get(i).getSongId());
                System.out.println(songList.get(i).getTitle());
            }
            System.out.println(songList.get(songList.size()-1).getSongId());
            System.out.println(songList.get(songList.size()-1).getTitle());
        }
    }

    private static double findSongDurationForArtist(List<Song> songs, String artist){
        return songs.stream()
                .filter(s -> s.getArtist().equalsIgnoreCase(artist))
                .mapToDouble(Song::getDuration)
                .sum();
    }

    private static List<Song> getSongsInAscendingOrder(List<Song> songs, String artist){
        return songs.stream()
                .filter(s -> s.getArtist().equalsIgnoreCase(artist))
                .sorted(Comparator.comparingDouble(Song::getDuration))
                .collect(Collectors.toList());
    }
}


class Song {

    private int songId;
    private String title;
    private String artist;
    private double duration;

    Song(int songId, String title, String artist, double duration) {
        this.songId = songId;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
    int getSongId() { return songId; }

    String getTitle() { return title; }

    String getArtist() { return artist; }

    double getDuration() { return duration; }

}


