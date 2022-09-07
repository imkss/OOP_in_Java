package MusicPlayer;

import java.util.*;

public class Main {
	
	private static ArrayList<Album> albums = new ArrayList<>();


	public static void main(String[] args) {
		

		Album album = new Album( "Album1","Honey Singh");
		
		album.addSong("Jingle Bell",3.8);
		album.addSong("Makhna",3.1);
		album.addSong("Dope Sope",4.1);
		album.addSong("Blue Eyes",2.9);
		albums.add(album);
		
		album = new Album( "Album2","The Weeknd");
		
		album.addSong("Save Your Tears",4.1);
		album.addSong("Die for You",2.9);
		album.addSong("Blinding Lights",3.1);
		albums.add(album);

		LinkedList<Song> playList_1 = new LinkedList<>();
		
//		albums.get(0).addToPlayList("Blinding Lights", playList_1);
		albums.get(0).addToPlayList("Jingle Bell", playList_1);
		albums.get(0).addToPlayList("Blue Eyes", playList_1);
		albums.get(1).addToPlayList("Die for You", playList_1);
		albums.get(1).addToPlayList("Save Your Tears", playList_1);
//		albums.get(1).addToPlayList("Dope Sope", playList_1);
		
		play(playList_1);
		
	}
	private static void play(LinkedList<Song> playList) {
		Scanner sc = new  Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listIterator = playList.listIterator();
		
		if(playList.size() == 0) {
			System.out.println("This playlist have no song");
		} else {
			System.out.println("Now playing "+ listIterator.next().toString());
			printMenu();
		}
		
		while(!quit) {
			int action = sc.nextInt();
			sc.nextLine();
			
			switch (action) {
			case 0: System.out.println("Playlist complete");
			quit = true;
			break;
			
			case 1: if(!forward) {
				if(listIterator.hasNext()) {
					listIterator.next();
					}
				forward = true;
			}
			if(listIterator.hasNext()) {
				System.out.println("Now playing "+ listIterator.next().toString());
			} else {
				System.out.println("No song available, reached to the end of the list");
				forward = false;
			}
			break;
			case 2: if(forward) {
				if(listIterator.hasPrevious()) {
					listIterator.previous();
				}
				forward = false;
			}
			if(listIterator.hasPrevious()) {
				System.out.println("Now playing "+ listIterator.previous().toString());
			} else {
				System.out.println("You are listning the first song");
				forward = false;
			}
			break;
			
			case 3: if(forward) {
				if(listIterator.hasPrevious()) {
					System.out.println("Now playing"+ listIterator.previous().toString());
					forward = false;
				} else  System.out.println("You are listning the first song");
					
			} else {
				if(listIterator.hasNext()) {
					System.out.println("Now playing "+ listIterator.next().toString());
					forward  = true;
				}else System.out.println("We have reached to the end of the list");
				
			}
			break;
			
			case 4: printList(playList);
			break;
			
			case 5: printMenu();
			break;
			
			case 6: if(playList.size() > 0) {
				listIterator.remove();
				if(listIterator.hasNext()) {
					System.out.println("Now playing "+ listIterator.next().toString());
					
				}
				else {
					if(listIterator.hasPrevious())
						System.out.println("Now playing"+ listIterator.previous().toString());
				}
			}
		}
	}
}

	private static void printMenu() {
		System.out.println("Available option\npress");
		System.out.println("0 - to quit\n"+
							"1 - to play next song\n"+
							"2 - to play preious song\n"+
							"3 - to replay the current song\n"+
							"4 - see the list\n"+
							"5 - print all available option\n"+
							"6 - delete current song");	
	}
	
	private static void printList(LinkedList<Song>playList) {
		Iterator<Song> iterator = playList.iterator();		
		System.out.println("-----------------------");
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("-----------------------");

	}
}
