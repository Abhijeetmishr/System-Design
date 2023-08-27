package DSA.CSES.Graph_Theory;

public class CountingRooms {
    int dx[] = {1, 0, -1, 0};
    int dy[] = {}
    public int countRooms(char[][] rooms){
        if(rooms.length == 0) return 0;
        int row = rooms.length;
        int col = rooms[0].length;
        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(rooms[i][j] == '.'){
                    count++;
                    dfs(rooms, row, col);
                }
            }
        }
    }
    
    public void dfs(char[][] rooms, int row, int col){

    }
}
