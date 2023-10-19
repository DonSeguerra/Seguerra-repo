 public class TableAndChairs {
    public static void main(String[] args) {
        int numRows = 7;
        int numCols = 26;

        char[][] pattern = PatternGenerator.generatePattern(numRows, numCols);
        PatternPrinter.printPattern(pattern);
    }
}

class PatternGenerator {
    public static char[][] generatePattern(int numRows, int numCols) {
        char[][] pattern = new char[numRows][numCols];

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                boolean isBorder = col == 0 || col == numCols - 1;
                boolean isFirstRow = row == 0 && col % 25 == 0;
                boolean isSecondRow = row == 1 && col % 25 == 0;
                boolean isThirdRow = row == 2 && col >= 8 && col <= 17;
                boolean isFourthRow = row == 3 && (col >= 1 && col <= 5 || col == 8 || col == 17 || (col >= 20 && col <= 25));
                boolean isFifthToSeventhRow = row >= 4 && row <= 6 && (col == 5 || col == 8 || col == 17 || col == 20);

                if (isBorder || isFirstRow || isSecondRow || isThirdRow || isFourthRow || isFifthToSeventhRow) {
                    pattern[row][col] = 'X';
                } else {
                    pattern[row][col] = ' ';
                }
            }
        }
        return pattern;
    }
}

class PatternPrinter {
    public static void printPattern(char[][] pattern) {
        for (char[] row : pattern) {
            System.out.println(new String(row));
        }
    }
}
