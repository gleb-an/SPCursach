import java.util.ArrayList;

/**
 * Created by bogdan on 21.12.2015.
 */
public class SplitString {


    public void tokenazer(String tempString) {

        String  newName = tempString.replaceAll(" ", "");

        char[] masElements = newName.toCharArray();
        String temp = "";
        boolean m = false;

        ArrayList<String> commands = new ArrayList<String>();
        ArrayList<String> commandsFinal = new ArrayList<String>();

        for (int i = 0; i < masElements.length; i++) {

            if(String.valueOf(masElements[i]).equals("(") | String.valueOf(masElements[i]).equals(")")
                    | String.valueOf(masElements[i]).equals("-") | String.valueOf(masElements[i]).equals("[") | String.valueOf(masElements[i]).equals("]")
                    | String.valueOf(masElements[i]).equals("*") | String.valueOf(masElements[i]).equals("=") | String.valueOf(masElements[i]).equals(";")) {

                if(m == true) commands.add(temp);
                m = false;
                temp = "";
                String s = "";

                if (String.valueOf(masElements[i]).equals(";")) {
                    commands.add(String.valueOf(masElements[i]));
                } else {
                    if (String.valueOf(masElements[i + 1]).equals("-") | String.valueOf(masElements[i]).equals("+")) {
                        s = String.valueOf(masElements[i]) + String.valueOf(masElements[i + 1]);
                        commands.add(s);
                        i++;
                    } else {
                        commands.add(String.valueOf(masElements[i]));
                    }
                }

            } else {
                temp += String.valueOf(masElements[i]);
                m = true;

            }

        }

        for (int i = 0; i < commands.size(); i++) {
            String x = commands.get(i) + " ";
            commandsFinal.add(x);
            System.out.print(commandsFinal.get(i));
        }
    }


}
