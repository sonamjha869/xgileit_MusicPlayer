package com.java.musicplayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class TestExecution {
	public static Comparator<Song> sortName = new Comparator<Song>() {

		@Override
		public int compare(Song s1, Song s2) {
			String name1 = s1.name;
			String name2 = s2.name;
			return name1.compareTo(name2);
		}
	};
	static ArrayList <Song> list = new ArrayList <Song>();


	static void printAllSong() { 
		for(int i = 0; i<list.size();i++) {
			Song s = list.get(i);
			System.out.println(s.getName()+" ");
			
		}
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("playing song" + name);
		display();
		
	}

	static void printAllSortedSong() {
		
		ArrayList<Song> sortedList = new ArrayList<Song>(list);
		Collections.sort(sortedList,sortName);
		for(int i = 0; i<sortedList.size();i++) {
			Song s = sortedList.get(i);
			System.out.println(s.getName()+" ");
			
		}
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("playing song" + name);
		display();
		
	}
	

	
	static void display() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 for all song");
		System.out.println("Enter 2 for all sorted song");
		System.out.println("Enter 3 for Album");
		System.out.println("Enter 4 for Artist");
		System.out.println("Enter 5 for adding song");
		System.out.println("Enter 6 for deleting song");
		
		int option = sc.nextInt();
		switch (option) {
		case 1:
			printAllSong();

			break;
		case 2:
			printAllSortedSong();

			break;
		case 3:

			printAlbum();
			break;
		case 4:
			printArtist();
			break;
		case 5:
			addSong();
			break;
		case 6:
			deleteSong();
			break;

		default:
			System.out.println("Default ");
		};

	
	}

	public static void main(String... args) {
		display();
	}

	private static void addSong() {
		Scanner sc = new Scanner(System.in);
		System.out.println("give the song details: song name");
		String name = sc.nextLine();
		System.out.println("give the song details: album name");
		String album = sc.nextLine();
		System.out.println("give the song details: artist name");
		String artist =sc.nextLine();
		System.out.println("song name  "+ name );
		System.out.println("album name "+ album);
		System.out.println( "artist name "+  artist);
		
		Song s = new Song();
		s.setName(name); 
		s.setAlbum(album); 
		s.artist = artist; 
		list.add(s);
		display();
		
	}

	private static void deleteSong() {
		for(int i = 0; i<list.size();i++) {
			Song s = list.get(i);
			System.out.println(s.getName()+" ");
			
		}
		System.out.println( "enter song name for deletion" );
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		for(int i = 0;i<list.size();i++) {
			Song s = list.get(i);
			String str =  s.getName();
			if(name.equals(str)){
				list.remove(i);
			}
		}
		
		System.out.println("deleted song " + name);
		
		display();
		
	}

	private static void printAlbum() {
		HashMap<String , ArrayList<String>> map =
				new HashMap<String, ArrayList<String>>();
		
		for(int i=0;i<list.size();i++) {
			Song s = list.get(i);
			String album = s.album;
			String name = s.name;
			
			if(map.containsKey(album)) {
				ArrayList<String> data = map.get(album);
				data.add(name);
				map.put(album, data);		
			} else {
				ArrayList<String> data = new ArrayList<String>();
				data.add(name);
				map.put(album, data);
			}
			
		}
		Set<String> set = map.keySet();
		for(String i : set) {
			System.out.println(i);
		}
		
		Scanner sc = new Scanner(System.in);
		String option = sc.nextLine();
		
		ArrayList<String> printName = map.get(option);
		
		for(int i =0 ;i<printName.size(); i++) {
			System.out.println(printName.get(i));
		}
		Scanner s1 = new Scanner(System.in);
		String name = s1.nextLine();
		System.out.println("playing song" + name);
		display();
		

		
			
		}



	private static void printArtist() {
		HashMap<String , ArrayList<String>> map =
				new HashMap<String, ArrayList<String>>();
		
		for(int i=0;i<list.size();i++) {
			Song s = list.get(i);
			String artist = s.artist;
			String name = s.name;
			
			if(map.containsKey(artist)) {
				ArrayList<String> data = map.get(artist);
				data.add(name);
				map.put(artist, data);		
			} else {
				ArrayList<String> data = new ArrayList<String>();
				data.add(name);
				map.put(artist, data);
			}
			
		}
		Set<String> set = map.keySet();
		for(String i : set) {
			System.out.println(i);
		}
		
		Scanner sc = new Scanner(System.in);
		String option = sc.nextLine();
		
		ArrayList<String> printName = map.get(option);
		
		for(int i =0 ;i<printName.size(); i++) {
			System.out.println(printName.get(i));
		}
		Scanner s1 = new Scanner(System.in);
		String name = s1.nextLine();
		System.out.println("playing song" + name);
		display();
		

		
			
		}
	

}
