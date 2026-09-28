import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormAluno extends JFrame implements ActionListener {
    private List<Aluno> ListaALunos;

    //Ccmponentes de entrada
    private JTextField txtNome;
    private JTextField txtIdade;
    private JTextField txtEndereco;

    //Botões de comando
    private JButton btnOk;
    private JButton btnLimpar;
    private JButton btnMostrar;
    private JButton btnSair;

    public FormAluno() {
        ListaALunos = new ArrayList<>();

        //Configuração da janela
        setTitle("TP02");
        setSize(400, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        //Parte superior
        JPanel painelCampos = new JPanel(new GridLayout(3, 2, 10, 10));

        painelCampos.add(new JLabel("Nome: "));
        txtNome = new JTextField();
        painelCampos.add(txtNome);

        painelCampos.add(new JLabel("Idade: "));
        txtIdade = new JTextField();
        painelCampos.add(txtIdade);

        painelCampos.add(new JLabel("Endereço: "));
        txtEndereco = new JTextField();
        painelCampos.add(txtEndereco);

        //Parte inferior
        JPanel painelBotoes = new JPanel(new GridLayout(1, 4, 5, 5));

        btnOk = new JButton("OK");
        btnOk.addActionListener(this);
        painelBotoes.add(btnOk);

        btnLimpar = new JButton("Limpar");
        btnLimpar.addActionListener(this);
        painelBotoes.add(btnLimpar);

        btnMostrar = new JButton("Mostrar");
        btnMostrar.addActionListener(this);
        painelBotoes.add(btnMostrar);

        btnSair = new JButton("Sair");
        btnSair.addActionListener(this);
        painelBotoes.add(btnSair);

        //Adicionair painéis ao JFrame
        add(painelCampos, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnOk) {
            String nome = txtNome.getText().trim();
            String idadeTexto = txtIdade.getText().trim();
            String endereco = txtEndereco.getText().trim();

            if (nome.isEmpty() || idadeTexto.isEmpty() || endereco.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Todos os campos devem ser preenchidos!",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                int idade = Integer.parseInt(idadeTexto);
                Aluno aluno = new Aluno(nome, idade, endereco);
                ListaALunos.add(aluno);

                JOptionPane.showMessageDialog(this,
                        "Aluno cadastrado com sucesso!",
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                LimparCampos();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Idade Inválida. Tente Novamente!",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnLimpar) {
            LimparCampos();

        } else if (e.getSource() == btnMostrar) {
            if (ListaALunos.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Nenhum aluno cadastrado até o momento!",
                        "Resultado", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("Resultado\n");
            for (Aluno a : ListaALunos) {
                sb.append("Id: ").append(a.getUuid()).append(" Nome: ").append(a.getNome()).append("\n");
            }

            JOptionPane.showMessageDialog(this, sb.toString(), "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } else if (e.getSource() == btnSair) {
            System.exit(0);
        }
    }

    private void LimparCampos() {
        txtNome.setText("");
        txtNome.requestFocus();
        txtIdade.setText("");
        txtEndereco.setText("");
    }
}

//Gustavo Cardoso Muniz e Izadora Santos Silva