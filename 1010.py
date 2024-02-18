produtoA = input().split(" ")
produtoB = input().split(" ")

codA,quantA,valA = produtoA
codB,quantB,valB = produtoB

total = (int(quantA) * float(valA) + (int(quantB) * float(valB)))

print(f'VALOR A PAGAR: R$ {total:.2f}')