from app import db

class Especie(db.Model):
    __tablename__ = "especies"

    id = db.Column(db.Integer, primary_key=True)
    nome = db.Column(db.String(), unique=True)
    linguagem = db.Column(db.String(), unique=True)

    def __repr__(self):
        return '<Especie %r>' % self.nome

class Personagem(db.Model):
    __tablename__ = "personagens"

    id = db.Column(db.Integer, primary_key=True)
    nome = db.Column(db.String(), unique=True)
    altura = db.Column(db.Integer, unique=True)
    peso = db.Column(db.Integer, unique=True)
    sexo = db.Column(db.String(), unique=True)
    anoDeNacimento = db.Column(db.String(), unique=True)
    especie_id = db.Column(db.Integer, db.ForeingKey('especies.id'))


    especie = db.relationship('Especie', ForeingKey=especie_id)

    def __repr__(self):
        return '<Personagem %r>' % self.nome



