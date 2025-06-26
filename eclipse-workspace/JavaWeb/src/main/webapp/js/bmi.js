function checkResult() {
		console.log('檢查資料');
		//const height = document.querySelector('input[name="height"]');//因為後端只能抓 name  所以主要以這個寫法為主
		//const weight = document.querySelector('input[name="weight"]');
		const height = document.getElementById('height');
		const weight = document.getElementById('weight');
		
		
		const h = height.value;
		const w = weight.value;
		console.log("身高",h,"體重",w);
		
		//計算BMI
		const bmi = w/((h/100)*(h/100));
		console.log("bmi",bmi);
		
		const result =bmi>23? '過重': bmi<=18? '過輕':'正常';
		const color = (result=='正常')? 'black':'red';
		console.log(result,color);
		document.getElementById('result').innerHTML=`BMI:${bmi.toFixed(2)} 診斷:<span style="color:${color}">${result}</span>`;	}