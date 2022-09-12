import java.net.*;
import java.io.*;

public class TCPEserver{
public static void main(String[] args) throws IOException{
 ServerSocket sock = null;
 BufferedReader fromClient=null;
 OutputStreamWriter toClient=null;
Socket client=null;
try{
 sock=new ServerSocket(4000);
System.out.println("server ready");
client =sock.accept();
System.out.println("client connected");
fromClient = new BufferedReader (new InputStreamReader(client.getInputStream()));
toClient=new OutputStreamWriter(client.getoutputStream());
String line;
while (true){
 line=fromClient.readline();
 if((line==null)||line.equals("bye"))
    break;
	System.out.println("Client["+line+"]");
	toClient.write("Srever["+line+"]\n");
	toClient.flush();
}
fromClient.close();
toClient.close();
client();
sock.close();
System.out.println("client disconnected");
}
catch(IOException ioe){
 System.err.println(ioe);
}
}
}