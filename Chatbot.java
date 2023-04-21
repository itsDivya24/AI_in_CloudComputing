import com.amazon.aws.services.lambda.runtime.Context;
import com.amazon.aws.services.lambda.runtime.RequestHandler;
import org.json.simple.JSONObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import java.awt.*;

public class Chatbot {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chatbot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(600, 400);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JTextArea chatArea = new JTextArea(20, 40);
        chatArea.setEditable(false);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        panel.add(chatScrollPane);
	  Font font = new Font("Arial", Font.PLAIN, 20);
	  chatArea.setFont(font);
	 
        JTextField inputField = new JTextField(60);
	  inputField.setFont(font);

        inputField.addActionListener(e -> {
            String input = inputField.getText();
            String response = getResponse(input);
            chatArea.append("You: " + input + "\n");
            chatArea.append("Chatbot: " + response + "\n");
            inputField.setText("");
		inputField.setBackground(Color.GRAY);
        });
        panel.add(inputField);
	  chatArea.setBackground(Color.PINK);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private static String getResponse(String input) {
        input = input.toLowerCase();
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.matches(".*\\bhi\\b.*|.*\\bhello\\b.*")) {
                return "Hello! How can I assist you?";
            } else if (token.matches(".*\\btime\\b.*|.*\\bclock\\b.*")) {
                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");
                Date date = new Date();
                return "The time is " + formatter.format(date);
            } 
		else if (token.matches(".*\\bweather\\b.*")) {
                return "Sorry, I am not yet capable of providing weather information.";
            }

		else if (token.matches(".*\\bhow\\b.*")) {
      	          return "I am fine. How about you?";
            }

		else if (token.matches(".*\\btalk\\b.*")) {
      	          return "Yeah sure. I would love to interact with you.";
            }


		else if (token.matches(".*\\bbye\\b.*|.*\\bBye\\b.*")) {
      	          return "Bye... It was nice talking to you.";
            }

		else if (token.matches(".*\\btell\\b.*|.*\\bTell\\b.*")) {
      	          return "I am a chatbot. I have been designed to talk to people across the world. I interact in English Language.";
            }


		else if (token.matches(".*\\bcountry\\b.*")) {
                return "If you are asking about the country you are currently in. I would say you're in India.";
            }
		else if (token.matches(".*\\bHi\\b.*|.*\\bhello\\b.*")) {
                return "Hello! How can I assist you?";}

		else if (token.matches(".*\\bsame\\b.*|.*\\bSame\\b.*")) {
                return "Thanks :-)";}
		
        }
        return "I am sorry, I do not understand your question.";
    }
}
