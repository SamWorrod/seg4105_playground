import java.io.*;
public class rankingSystem {

    //Gets input from user
    BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

    //Creating filewriter
    File songFile = new File ("songChoices.txt");
    BufferedWriter songWriter = new BufferedWriter (new FileWriter(songFile));

    //Testing purpose
    boolean tracing = true;
    public static void main(String[] args) throws Exception{
        new rankingSystem();
    }
    rankingSystem() throws Exception {

        //List of all the songs
        String [] songList = new String[]{"We Don’t Care", "All Falls Down", "Spaceship", "Jesus Walks", "Slow Jamz",
                "Through The Wire", "Family Business", "Last Call", "Heard ‘Em Say", "Touch the Sky", "Gold Digger", "Roses",
                "Diamonds From Sierra Leone", "We Major", "Hey Mama", "Gone", "Good Morning", "Champion", "Stronger", "Good Life",
                "Can’t Tell Me Nothing", "Flashing Lights", "Homecoming", "Big Brother", "Say You Will", "Welcome to Heartbreak",
                "Heartless", "Amazing", "Street Lights", "Pinocchio Story", "Dark Fantasy", "Gorgeous", "Power", "All of the Lights",
                "Monster", "Runaway", "Blame Game", "Lost in the World", "Fellas In Paris", "Otis", "Gotta Have It",
                "Murder To Excellence", "Made In America", "Black Skinhead", "New Slaves", "Hold My Liquor", "I'm In It",
                "Blood On the Leaves", "Send It Up", "Bound 2", "Ultralight Beam", "Father Stretch My Hands Pt. 1", "Famous",
                "Highlights", "Waves", "FML", "Real Friends", "Wolves", "No More Parties in LA", "Saint Pablo",
                "I Thought About Killing You", "Yikes", "All Mine", "Ghost Town", "Violent Crimes", "Fire", "Freeee",
                "Kids See Ghosts", "Cudi Montage"};

        //pickNumbers
        int pickOne;
        int pickTwo;
        int pickThree;
        int pickFour;

        //songTitles
        String songOne;
        String songTwo;
        String songThree;
        String songFour;

        //Arrays used to count
        int [] songAppearances = new int[69];
        int [] topSong = new int[69];
        int [] worstSong = new int [69];

        //gets random numbers for songs and runs 100 questions
        for(int i = 1; i<101; i++){
            pickOne = (int)(Math.random() * 69);
            do{
                pickTwo = (int)(Math.random() * 69);
            }while(pickTwo==pickOne);
            do{
                pickThree = (int)(Math.random() * 69);
            }while(pickThree==pickOne||pickThree==pickTwo);
            do{
                pickFour = (int)(Math.random() * 69);
            }while(pickFour==pickOne||pickFour==pickTwo||pickFour==pickThree);

            //increments appearances of songs
            songAppearances[pickOne]++;
            songAppearances[pickTwo]++;
            songAppearances[pickThree]++;
            songAppearances[pickFour]++;

            //Gets names of songs from random picks
            if(tracing){
                System.out.println("----------------------------------------------------");
                System.out.println("" + pickOne +"");
                System.out.println("" + pickTwo +"");
                System.out.println("" + pickThree +"");
                System.out.println("" + pickFour +"");
                System.out.println("----------------------------------------------------");
            }
            songOne = songList[pickOne];
            songTwo = songList[pickTwo];
            songThree = songList[pickThree];
            songFour = songList[pickFour];

            //Presents songs and asks users to rank
            System.out.println("Round " + i + " of 100: Please type a number, then hit Enter");
            System.out.println("----------------------------------------------------");
            System.out.println("1. " + songOne +"");
            System.out.println("2. " + songTwo +"");
            System.out.println("3. " + songThree +"");
            System.out.println("4. " + songFour +"");
            if(tracing){
                System.out.println("----------------------------------------------------");
                System.out.println("" + pickOne +"");
                System.out.println("" + pickTwo +"");
                System.out.println("" + pickThree +"");
                System.out.println("" + pickFour +"");
            }
            System.out.println("----------------------------------------------------");

            //Get the pick of the best song of the group
            String bestPick;

            //loops if input is unable to be processed
            do{
                System.out.print("Number of best song: ");
                bestPick = br.readLine();
                if(!bestPick.equals("1") && !bestPick.equals("2") && !bestPick.equals("3") && !bestPick.equals("4") && !bestPick.equals("Stop")){
                    System.out.print("Invalid entry, please pick again: ");
                }
            }while(!bestPick.equals("1") && !bestPick.equals("2") && !bestPick.equals("3") && !bestPick.equals("4") && !bestPick.equals("Stop"));

            //increments best pick
            if(bestPick.equals("1")){
                topSong[pickOne]++;
            } else if(bestPick.equals("2")){
                topSong[pickTwo]++;
            } else if(bestPick.equals("3")){
                topSong[pickThree]++;
            } else if(bestPick.equals("4")){
                topSong[pickFour]++;
            } else if(bestPick.equals("Stop")){
                break;
            }

            //Get the pick of the worst song of the group
            String worstPick;

            //loops if input is unable to be processed
            do{
                System.out.print("Number of worst song: ");
                worstPick = br.readLine();
                if(!worstPick.equals("1") && !worstPick.equals("2") && !worstPick.equals("3") && !worstPick.equals("4") && !worstPick.equals("Stop")){
                    System.out.print("Invalid entry, please pick again: ");
                }
            }while(!worstPick.equals("1") && !worstPick.equals("2") && !worstPick.equals("3") && !worstPick.equals("4") && !worstPick.equals("Stop"));

            //increments worst pick
            if(worstPick.equals("1")){
                worstSong[pickOne]++;
            } else if(worstPick.equals("2")){
                worstSong[pickTwo]++;
            } else if(worstPick.equals("3")){
                worstSong[pickThree]++;
            } else if(worstPick.equals("4")){
                worstSong[pickFour]++;
            } else if(worstPick.equals("Stop")){
                break;
            }


        }

        //Creates file of all song appearances and rankings
        System.out.println("Creating File...");
        for(int i=0; i<69; i++){
            songWriter.write((i+1) + ": " + songList[i] + ": " + songAppearances[i] + " Appearances, " + topSong[i] +" Top Spots, " + worstSong[i] + " Bottom Spots");
            songWriter.newLine();
        }
        songWriter.close();
        System.out.print("File Created. Press Enter to Exit Program:");
        br.readLine();
        System.exit(0);



    }
}
