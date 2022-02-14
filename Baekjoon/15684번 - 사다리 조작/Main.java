import java.io.*;
import java.util.StringTokenizer;

public class Main{
   static int n,m,h;
   static boolean[][] lad;
   static int min = -1;
   static boolean done = false;
   public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());
      lad = new boolean[h+1][n+1];
      for(int i=0;i<m;i++) {
         st = new StringTokenizer(br.readLine());
         int y = Integer.parseInt(st.nextToken());
         int x = Integer.parseInt(st.nextToken());
         lad[y][x] =true;
      }
      for(int i=0;i<4;i++) {
    	  ds(0,0,0,i);
    	  if(done) break;
      }
      System.out.print(min);
   }
   
   public static void ds(int x,int y, int cnt,int limit) {
      if(done) return;
	  if(cnt>limit) return;
      
      if(issame()) {
         min = cnt;
         done = true;
         return;
      }
      
      for(int i=y;i<=h;i++) {
    	  for(int j=1;j<n;j++) {
    		  if(!lad[i][j] && !lad[i][j-1]) {
    			  lad[i][j] = true;
    			  ds(j+1,i,cnt+1,limit);
    			  lad[i][j] = false;
    		  }
    	  }
      }
   }
   
   public static boolean issame() {
      for(int j=1;j<=n;j++) {
         int tx=j;
         for(int i=1;i<=h;i++) {
            if(lad[i][tx])tx+=1;
            else if(tx!=0) if(lad[i][tx-1]) tx-=1;
         }
         if(tx!=j) return false;
      }
      return true;
   }
}