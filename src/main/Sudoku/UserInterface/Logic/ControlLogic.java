package UserInterface.Logic;

import Constant.GameState;
import Constant.Messages;
import ProblemDomain.IStorage;
import ProblemDomain.SudokuGame;
import UserInterface.IUserInterfaceContract;

import java.io.IOException;

public class ControlLogic implements IUserInterfaceContract.EventListener {

    private IStorage storage;
    private IUserInterfaceContract.View view;

    public ControlLogic(IStorage storage, IUserInterfaceContract.View view) {
        this.storage = storage;
        this.view = view;
    }

    @Override
    public void onSudokuInput(int x, int y, int input) {
        try {
            SudokuGame gameDate = storage.getGameData();
            int[][] newGridState = gameDate.getCopyOFGridState();
            newGridState[x][y] = input;

            gameDate = new SudokuGame(
                    GameLogic.checkForCompletion(newGridState),
                    newGridState
            );

            storage.updateGameData(gameDate);

            view.updateSquare(x, y, input);

            if (gameDate.getGameState() == GameState.COMPLETE) {
                view.showDialog(Messages.GAME_COMPLETE);
            }
        } catch (IOException e) {
            e.printStackTrace();
            view.showError(Messages.ERROR);
        }
    }

    @Override
    public void onDialogClick() {
        try {
            storage.updateGameData(
                    GameLogic.getNewgame()
            );

            view.updateBoard(storage.getGameData());
        }catch (IOException e) {
            view.showError(Messages.ERROR);

        }

    }
}
