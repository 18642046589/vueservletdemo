			var items = document.getElementsByClassName("item")
			var pointd = document.getElementsByClassName("point")
			var gonext = document.getElementById("goNext");
			var goback = document.getElementById("goBack");

			var index = 0;

			function clears() {
				for (var i = 0; i < items.length; i++) {
					items[i].className = "item";

				}
				for (var i = 0; i < pointd.length; i++) {
					pointd[i].className = "point";

				}
			}

			function goindex() {
				clears();
				index++;
				if (index >= items.length & index >= pointd.length) {
					index = 0;
				}
				items[index].className = "item actives";
				pointd[index].className = "point activess";
			}

			function gobacks() {
				clears();
				index--;
				if (index < 0) {
					index = items.length - 1;
					index = pointd.length - 1;
				}
				items[index].className = "item actives";
				pointd[index].className = "point activess";
			}

			function date1() {
				clears();
				items[0].className = "item actives";
				pointd[0].className="point activess ";
				index = 0;
			}

			function date2() {
				clears();
				items[1].className = "item actives";
				pointd[1].className="point activess ";
				index = 1;
			}

			function date4() {
				clears();
				items[3].className = "item actives";
				pointd[3].className="point activess ";
				index = 3;
			}

			function date3() {
				clears();
				items[2].className = "item actives";
				pointd[2].className="point activess ";
				index = 2;
			}

			function date5() {
				clears();
				items[4].className = "item actives";
				pointd[4].className="point activess ";
				index = 4;
			}
			
			function xunhuan(){
				if(index>=items.length){
					index=0;
				}
				goindex();
			}
			setInterval(xunhuan,8000);