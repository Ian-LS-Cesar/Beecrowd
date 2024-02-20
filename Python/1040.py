n1, n2, n3, n4 = map(float, input().split())

notaRecu = 0
media = (n1*2 + n2*3 + n3*4 + n4*1)/10


print(f"Media: {media:.1f}")

if (media >= 7):
    print("Aluno aprovado.")
elif (5 <= media <= 6.9):
    print("Aluno em exame.")

    notaRecu = float(input())
    mediaRecu = (media + notaRecu) / 2
    print(f"Nota do exame: {notaRecu:.1f}")
    if (mediaRecu >= 5.0):
        print("Aluno aprovado.")
        print(f"Media final: {mediaRecu:.1f}")
    else:
        print("Aluno reprovado.")
        print(f"Media final: {mediaRecu:.1f}")
else:
    print("Aluno reprovado.")