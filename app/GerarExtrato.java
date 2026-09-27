package app;
import java.util.List;
import java.util.ArrayList;

public class GerarExtrato{
    private List<String> extrato =  new ArrayList<String>();
    public void push(String message){
        this.extrato.add(message);
    }

    @Override
    public String toString() {
        return this.extrato.toString();
    }

}

