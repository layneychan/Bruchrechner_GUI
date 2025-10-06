import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Main
{
    Calculations calc;

    private JPanel mainPnl;
    private JTextField frac1numerator;
    private JTextField frac1denominator;
    private JTextField frac2numerator;
    private JTextField frac2denominator;
    private JTextArea resultArea;
    private JButton equalsBtn;
    private JComboBox<String> operationCb;
    private JButton resetBtn;

    public Main()
    {
        equalsBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int numer1 = Integer.parseInt(frac1numerator.getText());
                int denom1 = Integer.parseInt(frac1denominator.getText());
                int numer2 = Integer.parseInt(frac2numerator.getText());
                int denom2 = Integer.parseInt(frac2denominator.getText());
                char operation = Objects.requireNonNull(operationCb.getSelectedItem()).toString().charAt(0);

                calc = new Calculations(numer1, denom1,  numer2, denom2, operation);

                calc.CalculateResult();
                resultArea.setText(calc.result);
            }
        });

        resetBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frac1numerator.setText("");
                frac1denominator.setText("");
                frac2numerator.setText("");
                frac2denominator.setText("");
                resultArea.setText("");
                operationCb.setSelectedIndex(0);
            }
        });
    }

    public static void main(String[] args)
    {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame =  new JFrame("Fraction Calculator");
        frame.setSize(700,200);
        frame.setContentPane(new Main().mainPnl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JTextField getFrac1numerator()
    {
        return frac1numerator;
    }

    public JTextField getFrac2numerator()
    {
        return frac2numerator;
    }

    public JTextField getFrac1denominator()
    {
        return frac1denominator;
    }

    public JTextField getFrac2denominator()
    {
        return frac2denominator;
    }

    public JComboBox<String> getOperation()
    {
        return operationCb;
    }

}
