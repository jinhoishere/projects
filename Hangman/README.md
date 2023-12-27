## Folder Structure

The workspace contains two folders, where:

- `src`: the folder to maintain sources (`Main.java` is the main class.)
- `lib`: the folder to maintain dependencies (pictures, a text file)

## GUI Structure

- `(JFrame)frame` = `(JPanel)mainPanel`
- `(JPanel)mainPanel` = `(LeftLabel)ll` + `(RightPanel)rp`
- `(RightPanel)rp` = `(TopPanel)top` + `(MiddlePanel)mid` + `(BottomPanel)bottom`

> `(TopPanel)top` displays blanks(underscores).
> `(BottonPanel)bottom` has `(Button)b`s, and each `(Button)b` has `(MyActionListener)e`

## File paths

To run these codes, you may need to fix file paths.

- `Main.java` class has file paths named `image_0`, `wordList`, and `mainIcon`.
- `MyActionListener` class has file paths named `image_5`, `image_6`, and a path that has variable in it, `line 56`