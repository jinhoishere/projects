## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources ("Main.java" to run code)
- `lib`: the folder to maintain dependencies (pictures, a text file)

## GUI Structure

`(JFrame)frame` = `(JPanel)mainPanel`
`(JPanel)mainPanel` = `(LeftLabel)ll` + `(RightPanel)rp`
* LeftLabel extends JLabel
* RightPanel extends JPanel
`(RightPanel)rp` = `(TopPanel)top` + `(BottomPanel)bottom`
* TopPanel extends JPanel
* BottomPanel extends JPanel
`(BottonPanel)bottom` = `(Button)b`
`(Button)b` = `(MyActionListener) extends ActionListener`


