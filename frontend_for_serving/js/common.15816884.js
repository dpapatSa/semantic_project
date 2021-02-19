(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["common"],{"02cd":function(t,a,r){"use strict";r.r(a);var o=function(){var t=this,a=t.$createElement,r=t._self._c||a;return r("div",[t.show?t._e():r("div",{staticClass:"row"},[r("card",{attrs:{type:"chart"}},[r("h4",[t._v("Please Wait Loading... ")])])],1),t.show?r("div",{staticClass:"row"},[r("div",{staticClass:"col-lg-12"},[r("card",{staticStyle:{color:"lightgrey"},attrs:{type:"chart"}},[r("ul",[r("label",{staticStyle:{"font-size":"14px"}},[t._v(" In the bar charts below, several statistics are illustrated for each ontology, namely: "),r("b",[t._v("number of classes")]),t._v(", "),r("b",[t._v("number of individuals")]),t._v(", "),r("b",[t._v("number of data-type properties")]),t._v(", "),r("b",[t._v("number of object properties")]),t._v(", and "),r("b",[t._v("number of axioms")]),t._v(". ")]),r("li",{staticStyle:{color:"grey"}},[t._v("Classes: groups of things or objects / sets of Individuals")]),r("li",{staticStyle:{color:"grey"}},[t._v("Individuals: instances of a class / actual objects of a domain")]),r("li",{staticStyle:{color:"grey"}},[t._v("Object Properties: connections between individuals")]),r("li",{staticStyle:{color:"grey"}},[t._v("Data-type properties: connections between individuals and literals – data values")]),r("li",{staticStyle:{color:"grey"}},[t._v("Axioms: statements that represent knowledge about the concept of the ontology")])])])],1),r("div",{staticClass:"col-lg-6"},[r("card",{attrs:{type:"chart"}},[r("template",{slot:"header"},[r("h3",{staticClass:"card-title"},[t._v("Number of Classes")])]),r("div",{staticClass:"chart-area"},[r("bar-chart",{staticStyle:{height:"100%"},attrs:{"chart-id":"green-bar-chart","chart-data":t.noOfClassesChart.chartData,"gradient-colors":t.noOfClassesChart.gradientColors,"gradient-stops":t.noOfClassesChart.gradientStops,"extra-options":t.noOfClassesChart.extraOptions}})],1)],2)],1),r("div",{staticClass:"col-lg-6"},[r("card",{attrs:{type:"chart"}},[r("template",{slot:"header"},[r("h3",{staticClass:"card-title"},[t._v("Number of Individuals")])]),r("div",{staticClass:"chart-area"},[r("bar-chart",{staticStyle:{height:"100%"},attrs:{"chart-id":"purple-bar-chart","chart-data":t.noOfIndividualsChart.chartData,"gradient-colors":t.noOfIndividualsChart.gradientColors,"gradient-stops":t.noOfIndividualsChart.gradientStops,"extra-options":t.noOfIndividualsChart.extraOptions}})],1)],2)],1),r("div",{staticClass:"col-lg-6"},[r("card",{attrs:{type:"chart"}},[r("template",{slot:"header"},[r("h3",{staticClass:"card-title"},[t._v("Number of DT Properties")])]),r("div",{staticClass:"chart-area"},[r("bar-chart",{staticStyle:{height:"100%"},attrs:{"chart-id":"blue-bar-chart","chart-data":t.noDTPropertiesChart.chartData,"gradient-stops":t.noDTPropertiesChart.gradientStops,"extra-options":t.noDTPropertiesChart.extraOptions}})],1)],2)],1),r("div",{staticClass:"col-lg-6"},[r("card",{attrs:{type:"chart"}},[r("template",{slot:"header"},[r("h3",{staticClass:"card-title"},[t._v("Number of Object Properties")])]),r("div",{staticClass:"chart-area"},[r("bar-chart",{staticStyle:{height:"100%"},attrs:{"chart-id":"green-bar-chart","chart-data":t.noObjPropertiesChart.chartData,"gradient-stops":t.noObjPropertiesChart.gradientStops,"extra-options":t.noObjPropertiesChart.extraOptions}})],1)],2)],1),r("div",{staticClass:"col-lg-6"},[r("card",{attrs:{type:"chart"}},[r("template",{slot:"header"},[r("h3",{staticClass:"card-title"},[t._v("Number of Axioms")])]),r("div",{staticClass:"chart-area"},[r("bar-chart",{staticStyle:{height:"100%"},attrs:{"chart-id":"purple-bar-chart","chart-data":t.noOfAxiomsChart.chartData,"gradient-colors":t.noOfAxiomsChart.gradientColors,"gradient-stops":t.noOfAxiomsChart.gradientStops,"extra-options":t.noOfAxiomsChart.extraOptions}})],1)],2)],1)]):t._e()])},e=[],s=(r("4160"),r("d3b7"),r("3ca3"),r("159b"),r("ddb0"),r("6636")),i=r("11d0"),c=r("1499"),l=r("93b4"),n=r("db49"),d=r("bc3a"),h=r.n(d),b=[],p=[],u=[],f=[],g=[],C={components:{LineChart:s["a"],BarChart:i["a"],Card:c["a"]},data:function(){return{show:!1,noObjPropertiesChart:{extraOptions:l["a"],chartData:{labels:["musicontology","foaf","dublincore","cidoc","pizza"],datasets:[{label:"Number of Object Properties",fill:!0,borderColor:n["a"].colors.danger,borderWidth:2,borderDash:[],borderDashOffset:0,data:p}]},gradientColors:n["a"].colors.primaryGradient,gradientStops:[1,.4,0]},noDTPropertiesChart:{extraOptions:l["a"],chartData:{labels:["musicontology","foaf","dublincore","cidoc","pizza"],datasets:[{label:"Number of DT Properties",fill:!0,borderColor:n["a"].colors.info,borderWidth:2,borderDash:[],borderDashOffset:0,data:b}]},gradientColors:n["a"].colors.primaryGradient,gradientStops:[1,.4,0]},noOfAxiomsChart:{extraOptions:l["a"],chartData:{labels:["musicontology","foaf","dublincore","cidoc","pizza"],datasets:[{label:"Number Of Axioms",fill:!0,borderColor:n["a"].colors.danger,borderWidth:2,borderDash:[],borderDashOffset:0,pointBackgroundColor:n["a"].colors.danger,pointBorderColor:"rgba(255,255,255,0)",pointHoverBackgroundColor:n["a"].colors.danger,pointBorderWidth:20,pointHoverRadius:4,pointHoverBorderWidth:15,pointRadius:4,data:u}]},gradientColors:["rgba(66,134,121,0.15)","rgba(66,134,121,0.0)","rgba(66,134,121,0)"],gradientStops:[1,.4,0]},noOfIndividualsChart:{extraOptions:l["a"],chartData:{labels:["musicontology","foaf","dublincore","cidoc","pizza"],datasets:[{label:"Number of Individuals",fill:!0,borderColor:n["a"].colors.info,borderWidth:2,borderDash:[],borderDashOffset:0,data:g}]},gradientColors:n["a"].colors.primaryGradient,gradientStops:[1,.4,0]},noOfClassesChart:{extraOptions:l["a"],chartData:{labels:["musicontology","foaf","dublincore","cidoc","pizza"],datasets:[{label:"Number of Classes",fill:!0,borderColor:n["a"].colors.primary,borderWidth:2,borderDash:[],borderDashOffset:0,data:f}]},gradientColors:n["a"].colors.primaryGradient,gradientStops:[1,.4,0]}}},methods:{get_data:function(){console.log("x")}},created:function(){for(var t=this,a=["musicontology","foaf","dublincore","cidoc","pizza"],r=[],o=0;o<5;o++)r.push(h.a.get("http://localhost:9090/Project_Final/webresources/"+a[o]+"/stats"));Promise.all(r).then((function(a){a.forEach((function(a){b.push(a.data.noDTProperties),p.push(a.data.noObjProperties),u.push(a.data.noOfAxioms),f.push(a.data.noOfClasses),g.push(a.data.noOfIndividuals),t.show=!0}))})).catch((function(t){console.log(t)}))}},m=C,v=r("2877"),y=Object(v["a"])(m,o,e,!1,null,null,null);a["default"]=y.exports},1171:function(t,a,r){"use strict";r.r(a);var o=function(){var t=this,a=t.$createElement,r=t._self._c||a;return r("div",[t.show?t._e():r("div",{staticClass:"row"},[r("card",{attrs:{type:"chart"}},[r("h4",[t._v("Please Wait Loading... ")])])],1),t.show?r("div",{staticClass:"row"},[r("div",{staticClass:"col-lg-12"},[r("card",{staticStyle:{color:"lightgrey"},attrs:{type:"chart"}},[t._v(" The graph below describes the ratio between similar classes and all classes in the ontology ")])],1),r("div",{staticClass:"col-lg-12"},[r("card",{attrs:{type:"chart"}},[r("template",{slot:"header"},[r("h3",{staticClass:"card-title"},[t._v("Equivalence Ratio (ER)")])]),r("div",{staticClass:"chart-area"},[r("bar-chart",{staticStyle:{height:"100%"},attrs:{"chart-id":"metric-bar-chart","chart-data":t.metricChart.chartData,"gradient-colors":t.metricChart.gradientColors,"gradient-stops":t.metricChart.gradientStops,"extra-options":t.metricChart.extraOptions}})],1)],2)],1)]):t._e()])},e=[],s=(r("4160"),r("d3b7"),r("3ca3"),r("159b"),r("ddb0"),r("6636")),i=r("11d0"),c=r("1499"),l=r("93b4"),n=r("db49"),d=r("bc3a"),h=r.n(d),b=[],p={components:{LineChart:s["a"],BarChart:i["a"],Card:c["a"]},data:function(){return{show:!1,metricChart:{extraOptions:l["a"],chartData:{labels:["musicontology","foaf","dublincore","cidoc","pizza"],datasets:[{label:"Number of Classes",fill:!0,borderColor:n["a"].colors.teal,borderWidth:2,borderDash:[],borderDashOffset:0,data:b}]},gradientColors:n["a"].colors.primaryGradient,gradientStops:[1,.4,0]}}},methods:{get_data:function(){console.log("x")}},created:function(){for(var t=this,a=["musicontology","foaf","dublincore","cidoc","pizza"],r=[],o=0;o<5;o++)r.push(h.a.get("http://localhost:9090/Project_Final/webresources/"+a[o]+"/metric6"));Promise.all(r).then((function(a){a.forEach((function(a){b.push(a.data),t.show=!0}))})).catch((function(t){console.log(t)}))}},u=p,f=r("2877"),g=Object(f["a"])(u,o,e,!1,null,null,null);a["default"]=g.exports},4068:function(t,a,r){"use strict";r.r(a);var o=function(){var t=this,a=t.$createElement,r=t._self._c||a;return r("div",[t.show?t._e():r("div",{staticClass:"row"},[r("card",{attrs:{type:"chart"}},[r("h4",[t._v("Please Wait Loading...")])])],1),t.show?r("div",{staticClass:"row"},[r("div",{staticClass:"col-lg-12"},[r("card",{staticStyle:{color:"lightgrey"},attrs:{type:"chart"}},[r("ul",[t._v(" In the pie charts below you can see the number of pitfall cases for each ontology, in slices. "),r("br"),t._v(" Specifically: "),r("br"),t._v(" - Missing Annotations "),r("br"),t._v(" - Unconnected Ontologies ")])])],1),r("div",{staticClass:"col-lg-6"},[r("card",[r("template",{slot:"header"},[r("h3",{staticClass:"card-title"},[t._v("Musicontology")])]),r("div",{staticClass:"chart-area"},[r("bar-chart",{staticStyle:{height:"100%"},attrs:{"chart-id":"purple-bar-chart","extra-options":t.barChart.extraOptions,"chart-data":t.barChart.musicontology_data_chart}})],1)],2)],1),r("div",{staticClass:"col-lg-6"},[r("card",[r("template",{slot:"header"},[r("h3",{staticClass:"card-title"},[t._v("Friend of a friend (FOAF)")])]),r("div",{staticClass:"chart-area"},[r("bar-chart",{attrs:{"chart-id":"purple-bar-chart","chart-data":t.barChart.foaf_data_chart}})],1)],2)],1),r("div",{staticClass:"col-lg-6"},[r("card",[r("template",{slot:"header"},[r("h3",{staticClass:"card-title"},[t._v("Dublincore")])]),r("div",{staticClass:"chart-area"},[r("bar-chart",{attrs:{"chart-id":"purple-bar-chart","chart-data":t.barChart.dublincore_data_chart}})],1)],2)],1),r("div",{staticClass:"col-lg-6"},[r("card",[r("template",{slot:"header"},[r("h3",{staticClass:"card-title"},[t._v("Cidoc")])]),r("div",{staticClass:"chart-area"},[r("bar-chart",{attrs:{"chart-id":"purple-bar-chart","chart-data":t.barChart.cidoc_data_chart}})],1)],2)],1),r("div",{staticClass:"col-lg-6"},[r("card",[r("template",{slot:"header"},[r("h3",{staticClass:"card-title"},[t._v("Pizza")])]),r("div",{staticClass:"chart-area"},[r("bar-chart",{attrs:{"chart-id":"purple-bar-chart","chart-data":t.barChart.pizza_data_chart}})],1)],2)],1)]):t._e()])},e=[],s=r("6636"),i=r("11d0"),c=r("1499"),l=r("93b4"),n=r("db49"),d=r("bc3a"),h=r.n(d),b=[],p=[],u=[],f=[],g=[],C={components:{LineChart:s["a"],BarChart:i["a"],Card:c["a"]},data:function(){return{show:!1,barChart:{type:"pie",musicontology_data_chart:{extraOptions:l["a"],labels:["MissingAnnotations","UnconnectedOntology"],datasets:[{label:"Musicontology",fill:!0,borderColor:n["a"].colors.danger,borderWidth:2,borderDash:[],borderDashOffset:0,data:b}],gradientColors:n["a"].colors.primaryGradient,gradientStops:[1,.4,0]},foaf_data_chart:{extraOptions:l["a"],labels:["MissingAnnotations","UnconnectedOntology"],datasets:[{label:"Foaf",fill:!0,borderColor:n["a"].colors.danger,borderWidth:2,borderDash:[],borderDashOffset:0,data:p}],gradientColors:n["a"].colors.primaryGradient,gradientStops:[1,.4,0]},cidoc_data_chart:{extraOptions:l["a"],labels:["MissingAnnotations","UnconnectedOntology"],datasets:[{label:"Cidoc",fill:!0,borderColor:n["a"].colors.danger,borderWidth:2,borderDash:[],borderDashOffset:0,data:u}],gradientColors:n["a"].colors.primaryGradient,gradientStops:[1,.4,0]},dublincore_data_chart:{extraOptions:l["a"],labels:["MissingAnnotations","UnconnectedOntology"],datasets:[{label:"Dublincore",fill:!0,borderColor:n["a"].colors.danger,borderWidth:2,borderDash:[],borderDashOffset:0,data:f}],gradientColors:n["a"].colors.primaryGradient,gradientStops:[1,.4,0]},pizza_data_chart:{extraOptions:l["a"],labels:["MissingAnnotations","UnconnectedOntology"],datasets:[{label:"Pizza",fill:!0,borderColor:n["a"].colors.danger,borderWidth:2,borderDash:[],borderDashOffset:0,data:g}],gradientColors:n["a"].colors.primaryGradient,gradientStops:[1,.4,0]}}}},created:function(){var t=this;this.show=!1,h.a.get("http://localhost:9090/Project_Final/webresources/musicontology/pitfalls").then((function(a){b.push(a.data.MissingAnnotations),b.push(a.data.UnconnectedOntology),h.a.get("http://localhost:9090/Project_Final/webresources/foaf/pitfalls").then((function(a){p.push(a.data.MissingAnnotations),p.push(a.data.UnconnectedOntology),h.a.get("http://localhost:9090/Project_Final/webresources/cidoc/pitfalls").then((function(a){u.push(a.data.MissingAnnotations),u.push(a.data.UnconnectedOntology),h.a.get("http://localhost:9090/Project_Final/webresources/dublincore/pitfalls").then((function(a){f.push(a.data.MissingAnnotations),f.push(a.data.UnconnectedOntology),h.a.get("http://localhost:9090/Project_Final/webresources/pizza/pitfalls").then((function(a){g.push(a.data.MissingAnnotations),g.push(a.data.UnconnectedOntology),t.show=!0}))}))}))}))}))}},m=C,v=r("2877"),y=Object(v["a"])(m,o,e,!1,null,null,null);a["default"]=y.exports},5799:function(t,a,r){"use strict";r.r(a);var o=function(){var t=this,a=t.$createElement,r=t._self._c||a;return r("div",[t.show?t._e():r("div",{staticClass:"row"},[r("card",{attrs:{type:"chart"}},[r("h4",[t._v("Please Wait Loading... ")])])],1),t.show?r("div",{staticClass:"row"},[r("div",{staticClass:"col-lg-12"},[r("card",{staticStyle:{color:"lightgrey"},attrs:{type:"chart"}},[t._v(" The graph below describes the appropriateness of module size to map the size of an ontology module. ")])],1),r("div",{staticClass:"col-lg-12"},[r("card",{attrs:{type:"chart"}},[r("template",{slot:"header"},[r("h3",{staticClass:"card-title"},[t._v("Appropriateness of module size")])]),r("div",{staticClass:"chart-area"},[r("bar-chart",{staticStyle:{height:"100%"},attrs:{"chart-id":"metric-bar-chart","chart-data":t.metricChart.chartData,"gradient-colors":t.metricChart.gradientColors,"gradient-stops":t.metricChart.gradientStops,"extra-options":t.metricChart.extraOptions}})],1)],2)],1)]):t._e()])},e=[],s=(r("4160"),r("d3b7"),r("3ca3"),r("159b"),r("ddb0"),r("6636")),i=r("11d0"),c=r("1499"),l=r("93b4"),n=r("db49"),d=r("bc3a"),h=r.n(d),b=[],p={components:{LineChart:s["a"],BarChart:i["a"],Card:c["a"]},data:function(){return{show:!1,metricChart:{extraOptions:l["a"],chartData:{labels:["musicontology","foaf","dublincore","cidoc","pizza"],datasets:[{label:"Number of Classes",fill:!0,borderColor:n["a"].colors.danger,borderWidth:2,borderDash:[],borderDashOffset:0,data:b}]},gradientColors:n["a"].colors.primaryGradient,gradientStops:[1,.4,0]}}},methods:{get_data:function(){console.log("x")}},created:function(){for(var t=this,a=["musicontology","foaf","dublincore","cidoc","pizza"],r=[],o=0;o<5;o++)r.push(h.a.get("http://localhost:9090/Project_Final/webresources/"+a[o]+"/metric2"));Promise.all(r).then((function(a){a.forEach((function(a){b.push(a.data),t.show=!0}))})).catch((function(t){console.log(t)}))}},u=p,f=r("2877"),g=Object(f["a"])(u,o,e,!1,null,null,null);a["default"]=g.exports},"71a8":function(t,a,r){"use strict";r.r(a);var o=function(){var t=this,a=t.$createElement,r=t._self._c||a;return r("div",[t.show?t._e():r("div",{staticClass:"row"},[r("card",{attrs:{type:"chart"}},[r("h4",[t._v("Please Wait Loading... ")])])],1),t.show?r("div",{staticClass:"row"},[r("div",{staticClass:"col-lg-12"},[r("card",{staticStyle:{color:"lightgrey"},attrs:{type:"chart"}},[t._v(" The graph below describes the average distribution of instances across all classes. ")])],1),r("div",{staticClass:"col-lg-12"},[r("card",{attrs:{type:"chart"}},[r("template",{slot:"header"},[r("h3",{staticClass:"card-title"},[t._v("Average Population")])]),r("div",{staticClass:"chart-area"},[r("bar-chart",{staticStyle:{height:"100%"},attrs:{"chart-id":"metric-bar-chart","chart-data":t.metricChart.chartData,"gradient-colors":t.metricChart.gradientColors,"gradient-stops":t.metricChart.gradientStops,"extra-options":t.metricChart.extraOptions}})],1)],2)],1)]):t._e()])},e=[],s=(r("4160"),r("d3b7"),r("3ca3"),r("159b"),r("ddb0"),r("6636")),i=r("11d0"),c=r("1499"),l=r("93b4"),n=r("db49"),d=r("bc3a"),h=r.n(d),b=[],p={components:{LineChart:s["a"],BarChart:i["a"],Card:c["a"]},data:function(){return{show:!1,metricChart:{extraOptions:l["a"],chartData:{labels:["musicontology","foaf","dublincore","cidoc","pizza"],datasets:[{label:"Number of Classes",fill:!0,borderColor:n["a"].colors.teal,borderWidth:2,borderDash:[],borderDashOffset:0,data:b}]},gradientColors:n["a"].colors.primaryGradient,gradientStops:[1,.4,0]}}},methods:{get_data:function(){console.log("x")}},created:function(){for(var t=this,a=["musicontology","foaf","dublincore","cidoc","pizza"],r=[],o=0;o<5;o++)r.push(h.a.get("http://localhost:9090/Project_Final/webresources/"+a[o]+"/metric4"));Promise.all(r).then((function(a){a.forEach((function(a){b.push(a.data),t.show=!0}))})).catch((function(t){console.log(t)}))}},u=p,f=r("2877"),g=Object(f["a"])(u,o,e,!1,null,null,null);a["default"]=g.exports},"74f1":function(t,a,r){"use strict";r.r(a);var o=function(){var t=this,a=t.$createElement,r=t._self._c||a;return r("div",[t.show?t._e():r("div",{staticClass:"row"},[r("card",{attrs:{type:"chart"}},[r("h4",[t._v("Please Wait Loading... ")])])],1),t.show?r("div",{staticClass:"row"},[r("div",{staticClass:"col-lg-12"},[r("card",{staticStyle:{color:"lightgrey"},attrs:{type:"chart"}},[t._v(" The graph below describes the average number of attributes per class. ")])],1),r("div",{staticClass:"col-lg-12"},[r("card",{attrs:{type:"chart"}},[r("template",{slot:"header"},[r("h3",{staticClass:"card-title"},[t._v("Attribute Richness")])]),r("div",{staticClass:"chart-area"},[r("bar-chart",{staticStyle:{height:"100%"},attrs:{"chart-id":"metric-bar-chart","chart-data":t.metricChart.chartData,"gradient-colors":t.metricChart.gradientColors,"gradient-stops":t.metricChart.gradientStops,"extra-options":t.metricChart.extraOptions}})],1)],2)],1)]):t._e()])},e=[],s=(r("4160"),r("d3b7"),r("3ca3"),r("159b"),r("ddb0"),r("6636")),i=r("11d0"),c=r("1499"),l=r("93b4"),n=r("db49"),d=r("bc3a"),h=r.n(d),b=[],p={components:{LineChart:s["a"],BarChart:i["a"],Card:c["a"]},data:function(){return{show:!1,metricChart:{extraOptions:l["a"],chartData:{labels:["musicontology","foaf","dublincore","cidoc","pizza"],datasets:[{label:"Number of Classes",fill:!0,borderColor:n["a"].colors.teal,borderWidth:2,borderDash:[],borderDashOffset:0,data:b}]},gradientColors:n["a"].colors.primaryGradient,gradientStops:[1,.4,0]}}},methods:{get_data:function(){console.log("x")}},created:function(){for(var t=this,a=["musicontology","foaf","dublincore","cidoc","pizza"],r=[],o=0;o<5;o++)r.push(h.a.get("http://localhost:9090/Project_Final/webresources/"+a[o]+"/metric3"));Promise.all(r).then((function(a){a.forEach((function(a){b.push(a.data),t.show=!0}))})).catch((function(t){console.log(t)}))}},u=p,f=r("2877"),g=Object(f["a"])(u,o,e,!1,null,null,null);a["default"]=g.exports},c744:function(t,a,r){"use strict";r.r(a);var o=function(){var t=this,a=t.$createElement,r=t._self._c||a;return r("div",[t.show?t._e():r("div",{staticClass:"row"},[r("card",{attrs:{type:"chart"}},[r("h4",[t._v("Please Wait Loading... ")])])],1),t.show?r("div",{staticClass:"row"},[r("div",{staticClass:"col-lg-12"},[r("card",{staticStyle:{color:"lightgrey"},attrs:{type:"chart"}},[t._v(" The graph below describes the ratio between the number of classes and the number of relationships in the ontology ")])],1),r("div",{staticClass:"col-lg-12"},[r("card",{attrs:{type:"chart"}},[r("template",{slot:"header"},[r("h3",{staticClass:"card-title"},[t._v("Class/Relation Ratio (CRR)")])]),r("div",{staticClass:"chart-area"},[r("bar-chart",{staticStyle:{height:"100%"},attrs:{"chart-id":"metric-bar-chart","chart-data":t.metricChart.chartData,"gradient-colors":t.metricChart.gradientColors,"gradient-stops":t.metricChart.gradientStops,"extra-options":t.metricChart.extraOptions}})],1)],2)],1)]):t._e()])},e=[],s=(r("4160"),r("d3b7"),r("3ca3"),r("159b"),r("ddb0"),r("6636")),i=r("11d0"),c=r("1499"),l=r("93b4"),n=r("db49"),d=r("bc3a"),h=r.n(d),b=[],p={components:{LineChart:s["a"],BarChart:i["a"],Card:c["a"]},data:function(){return{show:!1,metricChart:{extraOptions:l["a"],chartData:{labels:["musicontology","foaf","dublincore","cidoc","pizza"],datasets:[{label:"Number of Classes",fill:!0,borderColor:n["a"].colors.teal,borderWidth:2,borderDash:[],borderDashOffset:0,data:b}]},gradientColors:n["a"].colors.primaryGradient,gradientStops:[1,.4,0]}}},methods:{get_data:function(){console.log("x")}},created:function(){for(var t=this,a=["musicontology","foaf","dublincore","cidoc","pizza"],r=[],o=0;o<5;o++)r.push(h.a.get("http://localhost:9090/Project_Final/webresources/"+a[o]+"/metric5"));Promise.all(r).then((function(a){a.forEach((function(a){b.push(a.data),t.show=!0}))})).catch((function(t){console.log(t)}))}},u=p,f=r("2877"),g=Object(f["a"])(u,o,e,!1,null,null,null);a["default"]=g.exports}}]);
//# sourceMappingURL=common.15816884.js.map