public class Rook extends Piece
{
    private int xPosition =7;
    private int yPosition=7;
    
    @Override
    public void move(int[] position, Board b)
    {
        if(canMove(position, b))
        {
            yPosition=position[0];
            xPosition=position[1];
        }
        

        
    }
    @Override
    public  boolean canMove(int[] xy, Board b)
    {
        
        if(xy[0] == yPosition)
        {
            int difference = xPosition - xy[1];
            if(difference<0)
            {
               for(int i = xPosition+1; i<=xy[1]; i++)
               {
                   if(!b.getBoard()[yPosition][i].equals(null))
                   {
                       if(b.getBoard()[yPosition][i].getType())
                       {
                           return false;
                        }
                    }
                    
                }
                return true;
            }
            if(difference>0)
            {
               for(int i = xPosition-1; i>=xy[1]; i--)
               {
                   if(!b.getBoard()[yPosition][i].equals(null))
                   {
                       if(b.getBoard()[yPosition][i].getType())
                       {
                           return false;
                        }
                    }
                    
                }
               return true;
            }
        }
        if(xy[1] == xPosition)
        {
            int difference = yPosition - xy[0];
            if(difference<0)
            {
               for(int i = yPosition+1; i<=xy[0]; i++)
               {
                   if(!b.getBoard()[i][xPosition].equals(null))
                   {
                       if(b.getBoard()[i][xPosition].getType())
                       {
                           return false;
                        }
                    }
                    
                }
                return true;
            }
            if(difference>0)
            {
               for(int i = yPosition-1; i>=xy[0]; i--)
               {
                   if(!b.getBoard()[i][xPosition].equals(null))
                   {
                       if(b.getBoard()[i][xPosition].getType())
                       {
                           return false;
                        }
                    }
                    
                }
               return true;
            }
        }
        return false;

    }
}