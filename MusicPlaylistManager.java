//Hannah Marielle O. Ceblano
//CITCS 1N-A
//Final challenge No.4

import java.util.Scanner;

class SongNode {
    String title;
    SongNode prev, next;

    SongNode(String title) {
        this.title = title;
        this.prev = null;
        this.next = null;
    }
}

class Playlist {
    private SongNode current = null;

    // Add a song to the playlist
    public void addSong(String title) {
        SongNode newSong = new SongNode(title);
        if (current == null) {
            // First song in the playlist
            current = newSong;
            current.next = current;
            current.prev = current;
        } else {
            // Insert new song at the end
            SongNode last = current.prev;
            last.next = newSong;
            newSong.prev = last;
            newSong.next = current;
            current.prev = newSong;
        }
        System.out.println("'" + title + "' added to the playlist.");
    }

    // Remove a song from the playlist
    public void removeSong(String title) {
        if (current == null) {
            System.out.println("The playlist is empty. No song to remove.");
            return;
        }

        SongNode song = current;
        boolean found = false;

        do {
            if (song.title.equals(title)) {
                found = true;
                break;
            }
            song = song.next;
        } while (song != current);

        if (found) {
            if (song.next == song) {
                // Only one song in the playlist
                current = null;
            } else {
                song.prev.next = song.next;
                song.next.prev = song.prev;
                if (song == current) {
                    current = song.next;
                }
            }
            System.out.println("'" + title + "' removed from the playlist.");
        } else {
            System.out.println("'" + title + "' not found in the playlist.");
        }
    }

    // Move to the next song
    public void moveNext() {
        if (current == null) {
            System.out.println("The playlist is empty.");
        } else {
            current = current.next;
            System.out.println("Now playing: '" + current.title + "'");
        }
    }

    // Move to the previous song
    public void movePrevious() {
        if (current == null) {
            System.out.println("The playlist is empty.");
        } else {
            current = current.prev;
            System.out.println("Now playing: '" + current.title + "'");
        }
    }

    // Display the currently playing song
    public void displayCurrentSong() {
        if (current == null) {
            System.out.println("The playlist is empty.");
        } else {
            System.out.println("Currently playing: '" + current.title + "'");
        }
    }

    // Display all songs in the playlist
    public void displayPlaylist() {
        if (current == null) {
            System.out.println("The playlist is empty.");
        } else {
            System.out.println("Playlist:");
            SongNode song = current;
            do {
                System.out.println(" - " + song.title);
                song = song.next;
            } while (song != current);
        }
    }
}

public class MusicPlaylistManager {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMusic Playlist Manager");
            System.out.println("1. Add a song");
            System.out.println("2. Remove a song");
            System.out.println("3. Play next song");
            System.out.println("4. Play previous song");
            System.out.println("5. Display current song");
            System.out.println("6. Display all songs");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the song title: ");
                    String title = scanner.nextLine();
                    playlist.addSong(title);
                    break;
                case 2:
                    System.out.print("Enter the song title to remove: ");
                    String removeTitle = scanner.nextLine();
                    playlist.removeSong(removeTitle);
                    break;
                case 3:
                    playlist.moveNext();
                    break;
                case 4:
                    playlist.movePrevious();
                    break;
                case 5:
                    playlist.displayCurrentSong();
                    break;
                case 6:
                    playlist.displayPlaylist();
                    break;
                case 7:
                    System.out.println("Exiting the Music Playlist Manager. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
