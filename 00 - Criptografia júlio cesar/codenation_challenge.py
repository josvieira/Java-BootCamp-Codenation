import requests
import json
import hashlib


request = requests.get("https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=bc3239f72d39ed3d086c059a2294caf24e5b5e44")

with open('answer.json', 'w') as arq_json:
    json.dump(json.loads(request.content),arq_json)

with open('answer.json', 'r') as arq_json:
    dict_json = json.load(arq_json)

t = len(dict_json['cifrado'])
decifrando = list()
for c in range(0, t):
    if 97 <= ord(dict_json['cifrado'][c]) <= 122:           # já que estaria tudo em minusculo não considerei
        i = chr(ord(dict_json['cifrado'][c]) - dict_json['numero_casas']) # a numeração dos maiusculos
        if ord(i) < 97:
            n = 97 - ord(i)
            i = chr(123 - n)

        decifrando.append(i)
    else:
        decifrando.append(dict_json['cifrado'][c])

dict_json['decifrado'] = ''.join(decifrando)
dict_json['resumo_criptografico'] = hashlib.sha1(dict_json['decifrado'].encode('utf-8')).hexdigest()

with open('answer.json', 'w') as arq_json:
    json.dump(dict_json, arq_json)


answer = {'answer': open('answer.json','rb')} #inicialmente o envio não estava dando certo pois não abri o arquivo para leitura

retorno = requests.post("https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=bc3239f72d39ed3d086c059a2294caf24e5b5e44",files=answer)
print(retorno.text)                                                                                 #e aqui ao invés de files coloquei answer e estava entre ""
print(retorno.status_code)


