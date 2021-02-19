
export const basicOptions = {
  maintainAspectRatio: false,
  legend: {
    display: false
  },
  responsive: true,
}; 

export let barChartOptions = {
  ...basicOptions,
  tooltips: {
    backgroundColor: '#f1f1f5', 
    titleFontColor: '#333',
    bodyFontColor: '#666',
    bodySpacing: 4,
    xPadding: 10,
    mode: "nearest",
    intersect: 0,
    position: "nearest"
  },
  scales: {
    yAxes: [{

      gridLines: {
        drawBorder: false,
        color: 'rgba(29,255,100,0.1)',
        zeroLineColor: "transparent",
      },
      ticks: {
        suggestedMin: 0,
        suggestedMax: 0,
        padding: 10,
        fontColor: "#9e9e9e"
      }
    }],
    xAxes: [{

      gridLines: {
        drawBorder: false,
        color: 'rgba(29,255,100,0.1)',
        zeroLineColor: "transparent",
      },
      ticks: {
        padding: 1,
        fontColor: "#9e9e9e"
      }
    }]
  }

}
