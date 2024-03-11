package DSA.Graph.BFS;
import java.util.*;

class RottingOranges{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while((t--)>0){
            int n,m;
            n= sc.nextInt();
            m=sc.nextInt();
            ArrayList<ArrayList<Integer> > a = new ArrayList<ArrayList<Integer> >();
            for(int i=0;i<n;i++){
                a.add(new ArrayList<Integer>());
            }
            for(int i=0;i<n;i++){
                for(int j = 0;j<m;j++){
                    a.get(i).add(sc.nextInt());
                }
            }
            int ans  = RottingOranges.rottingOranges(a);
            System.out.println(ans);
        }
        sc.close();
    }
    public static int rottingOranges(ArrayList<ArrayList<Integer>> a){
        int[][] grid = new int[a.size()][];

        int days = 0, tot = 0, cnt = 0;

        for(int i = 0; i < a.size(); i++){
            grid[i] = new int[a.get(i).size()];
            for(int j = 0; j < a.get(i).size(); j++){
                grid[i][j] = a.get(i).get(j);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }if(grid[i][j] != 0) {
                    tot++;
                }
            }
        }

        int count = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            cnt += size;

            for(int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for(int j = 0; j < 4; j++){
                    int x = curr[0] + dx[j];
                    int y = curr[1] + dy[j];

                    if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length
                        || grid[x][y] == 0 || grid[x][y] == 2){
                            continue;
                    }
                    grid[x][y] = 2;
                    queue.add(new int[]{x,y});
                }
            }
            if(!queue.isEmpty()) days++;
        }

        return tot == cnt ? days : -1;
    }
}
