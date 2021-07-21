<template>
  <div> 
    <div class="row" v-if="!show">
      <card type="chart"> <h4>Please Wait Loading... </h4></card>
    </div>
    <div class="row" v-if="show">
      <div class="col-lg-12">
        <card type="chart" style="color:lightgrey">
          <ul>
            <label style="font-size:14px">
              In the bar charts below, several statistics are illustrated for each ontology, namely: 
              <b>number of classes</b>, 
              <b>number of individuals</b>, 
              <b>number of data-type properties</b>, 
              <b>number of object properties</b>, 
              and <b>number of axioms</b>.
              </label>
            <li style="color: grey">Classes: groups of things or objects / sets of Individuals</li>
            <li style="color: grey">Individuals: instances of a class / actual objects of a domain</li>
            <li style="color: grey">Object Properties: connections between individuals</li>
            <li style="color: grey">Data-type properties: connections between individuals and literals – data values</li>
            <li style="color: grey">Axioms: statements that represent knowledge about the concept of the ontology</li>  
          </ul>
        </card>
      </div>
      <div class="col-lg-6">
        <card type="chart">
          <template slot="header">
            <h3 class="card-title">Number of Classes</h3>
          </template>
          <div class="chart-area">
            <bar-chart
              style="height: 100%"
              chart-id="green-bar-chart"
              :chart-data="noOfClassesChart.chartData"
              :gradient-colors="noOfClassesChart.gradientColors"
              :gradient-stops="noOfClassesChart.gradientStops"
              :extra-options="noOfClassesChart.extraOptions"
            >
            </bar-chart>
          </div>
        </card>
      </div>
      <div class="col-lg-6">
        <card type="chart">
          <template slot="header">
            <h3 class="card-title">Number of Individuals</h3>
          </template>
          <div class="chart-area">
            <bar-chart
              style="height: 100%"
              chart-id="purple-bar-chart"
              :chart-data="noOfIndividualsChart.chartData"
              :gradient-colors="noOfIndividualsChart.gradientColors"
              :gradient-stops="noOfIndividualsChart.gradientStops"
              :extra-options="noOfIndividualsChart.extraOptions"
            >
            </bar-chart>
          </div>
        </card>
      </div>
      <div class="col-lg-6">
        <card type="chart">
          <template slot="header">
            <h3 class="card-title">Number of DT Properties</h3>
          </template>
          <div class="chart-area">
            <bar-chart
              style="height: 100%"
              chart-id="blue-bar-chart"
              :chart-data="noDTPropertiesChart.chartData"
              :gradient-stops="noDTPropertiesChart.gradientStops"
              :extra-options="noDTPropertiesChart.extraOptions"
            >
            </bar-chart>
          </div>
        </card>
      </div>
      <div class="col-lg-6">
        <card type="chart">
          <template slot="header">
            <h3 class="card-title">Number of Object Properties</h3>
          </template>
          <div class="chart-area">
            <bar-chart
              style="height: 100%"
              chart-id="green-bar-chart"
              :chart-data="noObjPropertiesChart.chartData"
              :gradient-stops="noObjPropertiesChart.gradientStops"
              :extra-options="noObjPropertiesChart.extraOptions"
            >
            </bar-chart>
          </div>
        </card>
      </div>

      <div class="col-lg-6">
        <card type="chart">
          <template slot="header">
            <h3 class="card-title">Number of Axioms</h3>
          </template>
          <div class="chart-area">
            <bar-chart
              style="height: 100%"
              chart-id="purple-bar-chart"
              :chart-data="noOfAxiomsChart.chartData"
              :gradient-colors="noOfAxiomsChart.gradientColors"
              :gradient-stops="noOfAxiomsChart.gradientStops"
              :extra-options="noOfAxiomsChart.extraOptions"
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

let noDTProperties_data = [];
let noObjProperties_data = [];
let noOfAxioms_data = [];
let noOfClasses_data = [];
let noOfIndividuals_data = [];
 

export default {
  components: {
    LineChart,
    BarChart,
    Card,
  },
  data() {
    return {
      show: false,
      noObjPropertiesChart: {
        extraOptions: chartConfigs.barChartOptions,
        chartData: {
          labels: ["bfo", "foaf", "dublincore", "cidoc", "obi"],
          datasets: [
            {
              label: "Number of Object Properties",
              fill: true,
              borderColor: config.colors.danger,
              borderWidth: 2,
              borderDash: [],
              borderDashOffset: 0.0,
              data: noObjProperties_data,
            },
          ],
        },
        gradientColors: config.colors.primaryGradient,
        gradientStops: [1, 0.4, 0],
      },
      noDTPropertiesChart: {
        extraOptions: chartConfigs.barChartOptions,
        chartData: {
          labels: ["bfo", "foaf", "dublincore", "cidoc", "obi"],
          datasets: [
            {
              label: "Number of DT Properties",
              fill: true,
              borderColor: config.colors.info,
              borderWidth: 2,
              borderDash: [],
              borderDashOffset: 0.0,
              data: noDTProperties_data,
            },
          ],
        },
        gradientColors: config.colors.primaryGradient,
        gradientStops: [1, 0.4, 0],
      },
      noOfAxiomsChart: {
        extraOptions: chartConfigs.barChartOptions,
        chartData: {
          labels: ["bfo", "foaf", "dublincore", "cidoc", "obi"],
          datasets: [
            {
              label: "Number Of Axioms",
              fill: true,
              borderColor: config.colors.danger,
              borderWidth: 2,
              borderDash: [],
              borderDashOffset: 0.0,
              pointBackgroundColor: config.colors.danger,
              pointBorderColor: "rgba(255,255,255,0)",
              pointHoverBackgroundColor: config.colors.danger,
              pointBorderWidth: 20,
              pointHoverRadius: 4,
              pointHoverBorderWidth: 15,
              pointRadius: 4,
              data: noOfAxioms_data,
            },
          ],
        },
        gradientColors: [
          "rgba(66,134,121,0.15)",
          "rgba(66,134,121,0.0)",
          "rgba(66,134,121,0)",
        ],
        gradientStops: [1, 0.4, 0],
      },
      noOfIndividualsChart: {
        extraOptions: chartConfigs.barChartOptions,
        chartData: {
          labels: ["bfo", "foaf", "dublincore", "cidoc", "obi"],
          datasets: [
            {
              label: "Number of Individuals",
              fill: true,
              borderColor: config.colors.info,
              borderWidth: 2,
              borderDash: [],
              borderDashOffset: 0.0,
              data: noOfIndividuals_data,
            },
          ],
        },
        gradientColors: config.colors.primaryGradient,
        gradientStops: [1, 0.4, 0],
      },
      noOfClassesChart: {
        extraOptions: chartConfigs.barChartOptions,
        chartData: {
          labels: ["bfo", "foaf", "dublincore", "cidoc", "obi"],
          datasets: [
            {
              label: "Number of Classes",
              fill: true,
              borderColor: config.colors.primary,
              borderWidth: 2,
              borderDash: [],
              borderDashOffset: 0.0,
              data: noOfClasses_data,
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
    var label = ["bfo", "foaf", "dublincore", "cidoc", "obi"];

    var promises = [];

    for (var i = 0; i < 5; i++) {
      promises.push(
        axios.get(
          "http://"+process.env.VUE_APP_BACKEND_HOST+":"+process.env.VUE_APP_BACKEND_PORT+"/Project_Final/webresources/" +
            label[i] +
            "/stats"
        )
      );
    }

    Promise.all(promises)
      .then((results) => {
        results.forEach((result) => {
          noDTProperties_data.push(result.data.noDTProperties);
          noObjProperties_data.push(result.data.noObjProperties);
          noOfAxioms_data.push(result.data.noOfAxioms);
          noOfClasses_data.push(result.data.noOfClasses);
          noOfIndividuals_data.push(result.data.noOfIndividuals);
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
