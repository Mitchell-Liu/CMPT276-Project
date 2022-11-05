package com.group20;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.LinkedList;



public class BFS {
    Map map;
    Queue<direction[]> directionQueue= new LinkedList<>();
    private int [][]maze=new int[20][20];
    
    private Position start;
    //3 is destination
    //2 is block being searched
    //1 is wall
    BFS(Map map,Position start){
        this.map=map;
        this.start=start;
        //System.out.println("shark location is: "+start.getX()+" "+start.getY());
        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                Position currPosition = new Position(i, j);
                switch (map.getEntityNameAt(currPosition)){
                    case "Diver":
                        maze[i][j]=3;
                        //System.out.println("diver location is: "+i+" "+j);
                        break;
                    case "Shark":
                        maze[i][j]=4;
                        break;
                    case "Wall":
                        maze[i][j]=1;
                        break; 
                    case "Coin":
                        maze[i][j]=1;
                        break;
                    case "TreasureChest":
                        maze[i][j]=1;
                        break;
                    case "Seaweed":
                        maze[i][j]=1;
                        break;
                    case "Exit":
                        maze[i][j]=1;      
                    default:
                            

                }
            }
        }

      

    }


    public direction Search(){
        Position currentPosition;
        while(true){
            /* 
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                //Thread.sleep(2000);
            } catch (InterruptedException e) {
            throw new IllegalStateException(e);
            }
            */
            if(directionQueue.size()==0){
                if(maze[start.getX()][start.getY()+1]==3){
                    return direction.down;
                 }
                 if(maze[start.getX()][start.getY()-1]==3){
                     return direction.up;
                 }
                 if(maze[start.getX()+1][start.getY()]==3){
                     return direction.right;
                 }
                 if(maze[start.getX()-1][start.getY()]==3){
                     return direction.left;
                 }
                if(maze[start.getX()][start.getY()+1]==0){
                    direction[] inputPath={direction.down};
                    //System.out.println("down for "+inputPath[0].name());
                    directionQueue.add(inputPath);
                    maze[start.getX()][start.getY()+1]=2;
                }
                if(maze[start.getX()][start.getY()-1]==0){
                    direction[] inputPath={direction.up};
                    //System.out.println("up for "+inputPath[0].name());
                    directionQueue.add(inputPath);
                    maze[start.getX()][start.getY()-1]=2;
                }
                if(maze[start.getX()+1][start.getY()]==0){
                    direction[] inputPath={direction.right};
                   // System.out.println("right for "+inputPath[0].name());
                    directionQueue.add(inputPath);
                    maze[start.getX()+1][start.getY()]=2;
                }
                if(maze[start.getX()-1][start.getY()]==0){
                    direction[] inputPath={direction.left};
                    //System.out.println("left for "+inputPath[0].name());
                    directionQueue.add(inputPath);
                    maze[start.getX()][start.getY()+1]=2;
                }
                //System.out.println("printing directionQueue:");
                /* 
                for(int i=0;i<directionQueue.size();i++){
                    direction[] inputPath=directionQueue.remove();
                    for(int j=0;j<inputPath.length;j++){
                        System.out.print(inputPath[j].name()+"");
                    }
                    System.out.println();
                }*/
                //for(direction[] elem:directionQueue){
                  //  for(int j=0;j<elem.length;j++){
                  //      System.out.print(elem[j].name()+"");
                  //  }
                  //  System.out.println();
                //}
                
            }
            else{

                 currentPosition=new Position(start.getX(),start.getY());
                direction[] topath=directionQueue.remove();
                //System.out.println("the startPosition is x:"+currentPosition.getX()+" y:"+currentPosition.getY());
                //System.out.print("the remove path is ");
                //for(int j=0;j<topath.length;j++){
                   // System.out.print(topath[j].name()+" || ");
                //}
                //System.out.println();
                int dx=0;
                int dy=0;
                for (int i=0;i<topath.length;i++){
                    switch(topath[i]){
                        case down:
                            dy++;
                        break;
                        case up:
                            dy--;
                        break;
                        case right:
                            dx++;
                        break;
                        case left:
                            dx--;
                        break;
                        case pause:
                        break;
                    }
                }
                currentPosition.setX(currentPosition.getX()+dx);
                currentPosition.setY(currentPosition.getY()+dy);
                //System.out.println("the curentPosition is x:"+currentPosition.getX()+" y:"+currentPosition.getY());
                //System.out.println("the curentPosition is x:"+(currentPosition.getX()+dx)+" y:"+(currentPosition.getY()+dy));
                //System.out.println();
                if(maze[currentPosition.getX()][currentPosition.getY()+1]==0){
                    direction[] inputPath=addOnPath(topath,direction.down);

                    //System.out.print("Adding direction array: ");
                  //  for(int j=0;j<inputPath.length;j++){
                        //System.out.print(inputPath[j].name()+"||");
                    //}
                    //System.out.println();

                    directionQueue.add(inputPath);
                }
                if(maze[currentPosition.getX()][currentPosition.getY()-1]==0){
                    
                    direction[] inputPath=addOnPath(topath,direction.up);
                    //System.out.print("Adding direction array: ");
                    //for(int j=0;j<inputPath.length;j++){
                        //System.out.print(inputPath[j].name()+"||");
                    //}
                    //System.out.println();
                    directionQueue.add(inputPath);
                }
                if(maze[currentPosition.getX()+1][currentPosition.getY()]==0){
                    
                    direction[] inputPath=addOnPath(topath,direction.right);
                    //System.out.print("Adding direction array: ");
                   // for(int j=0;j<inputPath.length;j++){
                       // System.out.print(inputPath[j].name()+"||");
                    //}
                    //System.out.println();
                    directionQueue.add(inputPath);
                }
                if(maze[currentPosition.getX()-1][currentPosition.getY()]==0){
                    
                    direction[] inputPath=addOnPath(topath,direction.left);
                    //System.out.print("Adding direction array: ");
                    //for(int j=0;j<inputPath.length;j++){
                      //  System.out.print(inputPath[j].name()+"||");
                   // }
                   // System.out.println();
                    directionQueue.add(inputPath);
                }

                if(maze[currentPosition.getX()][currentPosition.getY()+1]==3){
                    return topath[0];
                 }
                 if(maze[currentPosition.getX()][currentPosition.getY()-1]==3){
                    return topath[0];
                 }
                 if(maze[currentPosition.getX()+1][currentPosition.getY()]==3){
                    return topath[0];
                 }
                 if(maze[currentPosition.getX()-1][currentPosition.getY()]==3){
                    return topath[0];
                 }

            }
        }

            
    }
     

    
    private direction[] addOnPath(direction[] previous,direction addOn){
        direction[] current=new direction[previous.length+1];
        for(int i=0;i <previous.length;i++){
            current[i]=previous[i];
        }
        current[previous.length]=addOn;
        return current;
    }
}
