## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources ("Main.java" to run code)
- `lib`: the folder to maintain dependencies (pictures, a text file)

## GUI Structure

- `(JFrame)frame` = `(JPanel)mainPanel`
- `(JPanel)mainPanel` = `(LeftLabel)ll` extends JLabel + `(RightPanel)rp` extends JPanel
- `(RightPanel)rp` = `(TopPanel)top` extends JPanel + `(BottomPanel)bottom` extends JPanel
- `(BottonPanel)bottom` = `(Button)b`
- `(Button)b` = `(MyActionListener)e` extends ActionListener


