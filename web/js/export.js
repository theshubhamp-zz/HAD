var exp = function (exportdiv){
	html2canvas(document.getElementById(exportdiv), {
		onrendered: function (canvas) {
			var imgData = canvas.toDataURL("image/png", 1.0);
			var pdf = new jsPDF('landscape','pt','b3');
			pdf.addImage(imgData, 'PNG', 0, 0);
			pdf.save("download.pdf");
		}
	});
}
