# Simple Tic Tac Toe Game

board = [" " for _ in range(9)]


def display_board():
    print()
    print(board[0], "|", board[1], "|", board[2])
    print("--+---+--")
    print(board[3], "|", board[4], "|", board[5])
    print("--+---+--")
    print(board[6], "|", board[7], "|", board[8])
    print()


def check_winner(player):
    wins = [
        [0, 1, 2],
        [3, 4, 5],
        [6, 7, 8],
        [0, 3, 6],
        [1, 4, 7],
        [2, 5, 8],
        [0, 4, 8],
        [2, 4, 6]
    ]

    for combo in wins:
        if board[combo[0]] == board[combo[1]] == board[combo[2]] == player:
            return True
    return False


player = "X"

while True:
    display_board()

    try:
        move = int(input(f"Player {player}, enter position (1-9): ")) - 1
    except ValueError:
        print("Enter a number only!")
        continue

    if move < 0 or move > 8:
        print("Invalid position!")
        continue

    if board[move] != " ":
        print("Position already taken!")
        continue

    board[move] = player

    if check_winner(player):
        display_board()
        print(f"🎉 Player {player} Wins!")
        break

    if " " not in board:
        display_board()
        print("It's a Draw!")
        break

    if player == "X":
        player = "O"
    else:
        player = "X"