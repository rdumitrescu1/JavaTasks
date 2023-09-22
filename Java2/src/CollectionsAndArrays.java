import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class BeatlesException extends Exception{
    public BeatlesException() {
        super("Beatles");
    }

}

public class CollectionsAndArrays {

public static boolean songIncludeRandomString(List<String> songFile, String randomString) {
    String[] words = randomString.split("\\s+");

    for (int i = 0; i < words.length; i++) {
        if (!songFile.contains(words[i]))
        {
            return false;
        }
    }
    return true;
}

    public static void main(String[] args) {
//Part1
        String song = " In the town where I was born\n" +
                "Lived a man who sailed to sea\n" +
                "And he told us of his life\n" +
                "In the land of submarines\n" +
                "So we sailed on to the sun\n" +
                "'Til we found a sea of green\n" +
                "And we lived beneath the waves\n" +
                "In our yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine\n" +
                "And our friends are all aboard\n" +
                "Many more of them live next door\n" +
                "And the band begins to play\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine\n" +
                "Full steam ahead, Mister Boatswain, full steam ahead\n" +
                "Full steam ahead it is, Sergeant\n" +
                "(Cut the cable, drop the cable)\n" +
                "Aye-aye, sir, aye-aye\n" +
                "Captain, captain\n" +
                "As we live a life of ease (a life of ease)\n" +
                "Every one of us (every one of us)\n" +
                "Has all we need (has all we need)\n" +
                "Sky of blue (sky of blue)\n" +
                "And sea of green (sea of green)\n" +
                "In our yellow (in our yellow)\n" +
                "Submarine (submarine, aha)\n" +
                "We all live in a yellow submarine\n" +
                "A yellow submarine, yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "A yellow submarine, yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine ";
        song = song.replace("\n", " ").replace(" , ", "").replace(",", "").replace("(", "").replace(")", "");
        song = song.toLowerCase();

        System.out.println("\n"+song);
        String[] ArrayOfWords = song.split(" ");
        System.out.println("\nArray of words:");
        int counter=0;

        for (int i = 0; i < ArrayOfWords.length; i++)
        {
            System.out.println(ArrayOfWords[i]);
            counter++;
        }
        System.out.println("\nNumber of words: "+counter+"\n");


    //Part2
        List<String> SongList = new ArrayList<>(Arrays.asList(ArrayOfWords));
        ArrayList<String> SongList2 = new ArrayList<String>(SongList);
        System.out.println("List: "+SongList);

        System.out.println("Number of words: "+ SongList.size());

        LinkedHashSet<String> set = new LinkedHashSet<String>();
        set.addAll(SongList);
        SongList.clear();
        SongList.addAll(set);
        System.out.println("List without duplicate elements: " + SongList);
        System.out.println("\nNumber of words after removing duplication: "+SongList.size());


        Collections.sort(SongList, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return Integer.compare(s.length(),t1.length());
            }
        });

        System.out.println("\nSorted SongList words by length: "+SongList);

//Part 3
        System.out.println(SongList2);
        for (int i = 0;i<SongList2.size()-2;i++){
            SongList2.remove("yellow");
            SongList2.remove("submarine");
        }
        System.out.println("The List after removing yellow and submarine words: "+SongList2);
        System.out.println(SongList2.size());

//Part 4
        ArrayList<String> songFile = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("song.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                songFile.addAll(Arrays.asList(line.split(" ")));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(songFile);

        String randomString = "Show must go on!";
        System.out.println(songIncludeRandomString(songFile,randomString));
        try {

            if(!songIncludeRandomString(songFile,randomString))
            {
                throw new BeatlesException();
            }

        }
        catch (BeatlesException e)
        {
            System.out.println("String not found "+e.getMessage());
        }


    }


}

