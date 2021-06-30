<template>
  <div> 
    <div class="row" v-if="!show">
      <card type="chart"> <h4>Please Wait Loading... </h4></card>
    </div>
    <div class="row" v-if="show">
      <div class="col-lg-12">
        <card type="chart" style="color:lightgrey">
          The graph below describes the ratio between the number of classes and the number of relationships in the ontology
        </card>
      </div>
      <div class="col-lg-12">
        <card type="chart">
          <template slot="header">
            <h3 class="card-title">Class/Relation Ratio (CRR)</h3>
          </template>
          <div class="chart-area">
            <bar-chart
              style="height: 100%"
              chart-id="metric-bar-chart"
              :chart-data="metricChart.chartData"
              :gradient-colors="metricChart.gradientColors"
              :gradient-stops="metricChart.gradientStops"
              :extra-options="metricChart.extraOptions"
            >
            </bar-chart>
          </div>
        </card>
      </div> 
    </div>
  </div>
</template>



<script>
import LineChart from "@/components/Charts/LineChart";
import BarChart from "@/components/Charts/BarChart";
import Card from "@/components/Cards/Card";

import * as chartConfigs from "@/components/Charts/config";
import config from "@/config";
import axios from "axios";

let metric_data = []; 
 

export default {
  components: {
    LineChart,
    BarChart,
    Card,
  },
  data() {
    return {
      show: false, 
      metricChart: {
        extraOptions: chartConfigs.barChartOptions,
        chartData: {
          labels: ["musicontology", "foaf", "dublincore", "cidoc", "pizza"],
          datasets: [
            {
              label: "Number of Classes",
              fill: true,
              borderColor: config.colors.teal,
              borderWidth: 2,
              borderDash: [],
              borderDashOffset: 0.0,
              data: metric_data,
            },
          ],
        },
        gradientColors: config.colors.primaryGradient,
        gradientStops: [1, 0.4, 0],
      },
    };
  }, 
  methods: {
    get_data: function () {  
      console.log("x")
    },
  },
  created() {
    var label = ["musicontology", "foaf", "dublincore", "cidoc", "pizza"];

    var promises = [];

    for (var i = 0; i < 5; i++) {
      promises.push(
        axios.get(
          "http://"+process.env.BACKEND_HOST+":"+process.env.BACKEND_PORT+"/Project_Final/webresources/" +
            label[i] +
            "/metric5"
        )
      );
    }

    Promise.all(promises)
      .then((results) => {
        results.forEach((result) => {  
          metric_data.push(result.data); 
          this.show = true;
        });
      })
      .catch((err) => {
        console.log(err);
      });
  },
};
</script>

<style>
</style>
