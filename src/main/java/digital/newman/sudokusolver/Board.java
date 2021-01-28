package digital.newman.sudokusolver;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class Board {
    private final Optional[][] cellValues = new Optional[9][9];

    public boolean isValid() {
        // each row must be valid
        // each column must be valid
        // each sub-grid must be valid
        return false;
    }

    public boolean isSolved() {
        return isValid() && Stream.of(cellValues).flatMap(Stream::of).noneMatch(Optional::isEmpty);
    }

    public Board(String[] cellValues) {
        int rowIndex = 0;
        for (String row : cellValues) {
            int columnIndex = 0;
            for (char cell : row.toCharArray()) {
                Optional<Integer> value = Optional.empty();
                if (cell >= '0' && cell <= '9') {
                    value = Optional.of(Character.getNumericValue(cell));
                }
                this.cellValues[rowIndex][columnIndex] = value;
                columnIndex++;
            }

            rowIndex++;
        }
    }

    public void solve(Solver solver) {

    }
}
