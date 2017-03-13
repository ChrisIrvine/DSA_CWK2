/*
 * 
 */
package q1;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;

/**
 *
 * @author ruw12gbu, 10003248
 */
public class CSVFileWriter 
{    
            
    public void writeCSVFile(String fileName, double[][] resultsMatrix, 
            int rows, int columns)
    {
        File csvFile = new File(fileName);
        
        try(BufferedWriter bW = new BufferedWriter(new FileWriter(csvFile)))
        {
            bW.write("\n");
            for(int i = 0; i < rows; i++)
            {
                for(int j = 0; j < columns; j++)
                {
                    bW.write(String.format("\"%f\",", resultsMatrix[i][j]));
                }
                bW.write("\n");//now do next row
            }           
        }
        catch(IOException ioex)
        {
            ioex.printStackTrace();
        }
    }
}
