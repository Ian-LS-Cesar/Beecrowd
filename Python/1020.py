idadeDias = int(input())
anos, meses, dias = 0, 0, 0

if (idadeDias >= 365):
    anos = idadeDias // 365
    idadeDias = idadeDias - anos * 365

if (idadeDias >= 30):
    meses = idadeDias // 30
    idadeDias = idadeDias - meses * 30
dias = idadeDias

print(f"{anos} ano(s)")
print(f"{meses} mes(es)")
print(f"{dias} dia(s)")