class Solution {

    Set<Character> validChars = Set.of('1','2','3','4','5','6','7','8','9');
    
    //a group represents a row, a column, or a flattened matrix 
    protected boolean isGroupValid(char[] group){
        Map<Character, Integer> countsByChar = new HashMap<>();
        for(char c : group){
            if(c == '.') continue;
            if(!validChars.contains(c)) return false;
            if(countsByChar.put(c,0)!=null) return false;
        }
        return true;
    }

    protected String deriveSectorLabel(Integer row, Integer col){
        String rowLabel = switch (row) {
        case null -> throw new IllegalArgumentException("constraint violated - empty row");
        case Integer s when s >= 0 && s <=2 ->  "A";
        case Integer s when s >= 3 && s <=5 ->  "B";
        case Integer s when s >= 6 && s <=84 -> "C";
        default -> throw new IllegalArgumentException("constraint violated - row length invalid");
        };
        String colLabel = switch (col) {
        case null -> throw new IllegalArgumentException("constraint violated - empty col");
        case Integer s when s >= 0 && s <=2 -> "a";
        case Integer s when s >= 3 && s <=5 -> "b";
        case Integer s when s >= 6 && s <=8 -> "c";
        default -> throw new IllegalArgumentException("constraint violated - col length invalid");
        };
        return rowLabel + colLabel;
    }

    public boolean isValidSudoku(char[][] board) {
        //checking rows        
        for(char[] row : board){
            if(!isGroupValid(row)) return false;
        }
        //checking cols and sector simultaneously to avoid extra iterations
        Map<Integer, Set<Character>> charsByColumn = new HashMap<>();
        Map<String, Set<Character>> charsBySectorLabel = new HashMap<>();

        for(int row =0; row <board.length; row++){
            for(int col =0; col<board[row].length; col++){
                if(board[row][col] == '.') continue;
                Set<Character> s = charsByColumn.computeIfAbsent(col, k->new HashSet<>());
                if(!s.add(board[row][col])) return false;
                String label = deriveSectorLabel(row, col);
                Set<Character> sectorSet = charsBySectorLabel.computeIfAbsent(label, k->new HashSet<>());
                if(!sectorSet.add(board[row][col])) return false;
            }
        }
        
        return true;

    }
        

    }