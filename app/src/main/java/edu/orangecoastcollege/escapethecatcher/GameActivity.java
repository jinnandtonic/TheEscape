package edu.orangecoastcollege.escapethecatcher;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class GameActivity extends AppCompatActivity {

    private GestureDetector gestureDetector;

    //FLING THRESHOLD VELOCITY
    final int FLING_THRESHOLD = 500;

    //BOARD INFORMATION
    final int SQUARE = 200;
    final int OFFSET = 5;
    final int COLS = 8;
    final int ROWS = 8;
    final int gameBoard[][] = {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 2, 2, 1, 2, 2, 1, 1},
            {1, 2, 2, 2, 2, 2, 2, 1},
            {1, 2, 1, 2, 2, 2, 2, 1},
            {1, 2, 2, 2, 2, 2, 1, 1},
            {1, 2, 2, 1, 2, 2, 2, 3},
            {1, 2, 1, 2, 2, 2, 2, 1},
            {1, 1, 1, 1, 1, 1, 1, 1}
    };
    private List<ImageView> allGameObjects;
    private Player player;
    private Zombie zombie;

    //LAYOUT AND INTERACTIVE INFORMATION
    private RelativeLayout activityGameRelativeLayout;
    private ImageView zombieImageView;
    private ImageView playerImageView;
    private TextView winsTextView;
    private TextView lossesTextView;

    private int exitRow;
    private int exitCol;

    //  WINS AND LOSSES
    private int wins;
    private int losses;

    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        activityGameRelativeLayout = (RelativeLayout) findViewById(R.id.activity_game);
        winsTextView = (TextView) findViewById(R.id.winsTextView);
        lossesTextView = (TextView) findViewById(R.id.lossesTextView);

        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        allGameObjects = new ArrayList<>();

        startNewGame();

    }

    private void startNewGame() {
        //TASK 1:  CLEAR THE BOARD (ALL IMAGE VIEWS)
//        for (int i = 0; i < allGameObjects.size(); i++) {
//            ImageView visualObj = allGameObjects.get(i);
//            activityGameRelativeLayout.removeView(visualObj);
//        }
        for (ImageView imageView : allGameObjects)
            activityGameRelativeLayout.removeView(imageView);
        allGameObjects.clear();

        //TASK 2:  REBUILD THE  BOARD
        buildGameBoard();

        //TASK 3:  ADD THE PLAYERS
        createZombie();
        createPlayer();

        winsTextView.setText(getString(R.string.wins, wins));
        lossesTextView.setText(getString(R.string.losses, losses));
    }

    private void buildGameBoard() {
        ImageView viewToInflate;

        // Loop through the board:
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                viewToInflate = null;
                if (gameBoard[row][col] == BoardCodes.OBSTACLE) {
                    viewToInflate = (ImageView) layoutInflater.inflate(R.layout.obstacle_layout, null);
                }
                else if (gameBoard[row][col] == BoardCodes.EXIT) {
                    viewToInflate = (ImageView) layoutInflater.inflate(R.layout.exit_layout, null);
                    exitRow = row;
                    exitCol = col;
                }

                if (viewToInflate != null) {
                    // SET the x and y position of the viewToInflate
                    viewToInflate.setX(col * SQUARE + OFFSET);
                    viewToInflate.setY(row * SQUARE + OFFSET);

                    // Add view to relative layout and list of image views
                    activityGameRelativeLayout.addView(viewToInflate);
                    allGameObjects.add(viewToInflate);
                }
            }
        }
    }

    private void createZombie() {
        // Determine where to place the Zombie (at game start)
        // Then, inflate the zombie layout
        int row = 2;
        int col = 4;

        zombieImageView = (ImageView) layoutInflater.inflate(R.layout.zombie_layout, null);
        zombieImageView.setX(col * SQUARE + OFFSET);
        zombieImageView.setY(row * SQUARE + OFFSET);

        // Add to relative layout and the list
        activityGameRelativeLayout.addView(zombieImageView);
        allGameObjects.add(zombieImageView);

        // instantiate zombie
        zombie = new Zombie(); // TODO: create a parametrized constructor for Zombie class
        zombie.setRow(row);
        zombie.setCol(col);
    }

    private void createPlayer() {
        // Determine where to place the Player (at game start)
        // Then, inflate the player layout
        int row = 1;
        int col = 1;

        activityGameRelativeLayout.addView(playerImageView);
        allGameObjects.add(playerImageView);

        playerImageView = (ImageView) layoutInflater.inflate(R.layout.player_layout, null);
        player = new Player(); // TODO: create a parametrized constructor for Player class
        playerImageView.setX(row);
        playerImageView.setY(col);
    }


    private void movePlayer(float velocityX, float velocityY) {
        // TODO: This method gets called by the onFling event
        // TODO: Be sure to implement the move method in the Player (model) class

        // TODO: Determine which absolute velocity is greater (x or y)
        // TODO: If x is negative, move player left.  Else if x is positive, move player right.
        // TODO: If y is negative, move player down.  Else if y is positive, move player up.

        // TODO: Then move the zombie, using the player's row and column position.
    }

}
