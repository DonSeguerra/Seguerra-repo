public class FavoriteSong {

    private String songTitle;
    private String artistName;
    private String[] verses;

    public FavoriteSong(String title, String artist, String[] verses) {
        this.songTitle = title;
        this.artistName = artist;
        this.verses = verses;
    }

    public void startSong() {
        System.out.println("Now playing: " + songTitle + " by " + artistName);
    }

    public void displayVerses() {
        System.out.println("Lyrics for " + songTitle + " by " + artistName + ":\n");
        for (String verse : verses) {
            System.out.println(verse);
        }
    }

    public static void main(String[] args) {
        String[] verses = {
            "I should be over all the butterflies, but I'm into you",
            "And baby even on the worst nights I'm into you",
            "Let 'em wonder how we got this far 'cause I don't at all",
            "Yeah, after all this time I'm still into you"
        };

        FavoriteSong myFavoriteSong = new FavoriteSong("Still into You", "Paramore", verses);

        myFavoriteSong.startSong();
        myFavoriteSong.displayVerses();
    }
}