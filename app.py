from flask import Flask, request, jsonify
import pickle
import numpy as np

model = pickle.load(open('model1.pkl', 'rb'))

app = Flask(__name__)


@app.route('/')
def home():
    return "Hello world"


@app.route('/predict', methods=['POST'])
def predict():
    sepal_length = request.form.get("sepal_len")
    sepal_width = request.form.get("sepal_wid")
    petal_length = request.form.get("petal_len")
    petal_width = request.form.get("petal_wid")

    input_query = np.array([[sepal_length, sepal_width, petal_length, petal_width]], dtype=float)

    result = model.predict(input_query)[0]

    return jsonify(result)


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080)
