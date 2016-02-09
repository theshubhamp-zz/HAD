function exp(){
	html2canvas(document.getElementById('export'), {
		onrendered: function (canvas) {
			var imgData = canvas.toDataURL("image/png", 1.0);
			var pdf = new jsPDF('landscape');
			pdf.addImage(imgData, 'PNG', 0, 0);
			pdf.save("download.pdf");
		}
	});
}
