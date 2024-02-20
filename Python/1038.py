codigo, quanti = map(int, input().split())

match codigo:
    case 1:
        valor = 4
    case 2:
        valor = 4.5
    case 3:
        valor = 5
    case 4:
        valor = 2
    case 5:
        valor = 1.5

preco = quanti * valor

print(f"Total: R$ {preco:.2f}")

