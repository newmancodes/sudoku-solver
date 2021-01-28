package digital.newman.sudokusolver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolverTests {
    @Test
    public void solved_board_is_solved() {
        // Arrange
        String[] cellValues = new String[] {
                "172549683",
                "645873219",
                "389261745",
                "496327851",
                "813456972",
                "257198436",
                "964715328",
                "731682594",
                "528934167"
        };

        // Act
        Board board = new Board(cellValues);

        // Assert
        assertTrue(board.isSolved());
    }

    @Test
    public void first_board_can_be_solved() {
        // Arrange
        String[] cellValues = new String[] {
                "      68 ",
                "    73  9",
                "3 9    45",
                "49       ",
                "8 3 5 9 2",
                "       36",
                "96    3 8",
                "7  68    ",
                " 28      "
        };
        Board board = new Board(cellValues);
        Solver solver = new BacktrackingSolver();

        // Act
        board.solve(solver);

        // Assert
        assertTrue(board.isSolved());
        String[] solvedCellValues = new String[] {
                "172549683",
                "645873219",
                "389261745",
                "496327851",
                "813456972",
                "257198436",
                "964715328",
                "731682594",
                "528934167"
        };
        Board solvedBoard = new Board(solvedCellValues);
        assertEquals(solvedBoard, board);
    }
}
