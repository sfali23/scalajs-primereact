const generatedConfig = require("./scalajs.webpack.config");
// const HtmlWebpackPlugin = require("html-webpack-plugin");
const path = require("path");

module.exports = generatedConfig;

module.exports = {
    "entry": {
        "demo-fastopt": ["./demo-fastopt.js"]
    },
    mode: "development",
    performance: {
        maxEntrypointSize: 400000
    },
    devServer: {
        contentBase: [
            __dirname,
            path.join(__dirname, "../../../../src/main/resources")
        ],
        watchContentBase: true
    },
    module: {
        rules: [
            /*{
                test: /\.scss$/,
                use: ["sass-loader"]
            },*/
            {
                test: /\.css$/,
                use: [
                    "style-loader",
                    "css-loader"
                ]
            },
            {
                test: /\.(png|woff|woff2|eot|ttf|svg)$/,
                use: [
                    {
                        loader: 'url-loader'
                    },
                ]
            },
            {
                test: /\.(png|jpe?g|gif)$/i,
                use: [
                    {
                        loader: 'file-loader',
                    },
                ],
            }
            /*,
            {
                test: /\.exec\.js$/,
                use: [ 'script-loader' ]
            }*/
            /*,
            {
                test: /\.js$/,
                loader: 'babel-loader',
                include: [
                    path.resolve(__dirname,'../../../../src/main/resources')
                ]
            }*/
            /*,
            {
                test: /\.html$/i,
                loader: 'html-loader',
            }*/
        ]
    },
    plugins: [
        /*new HtmlWebpackPlugin({
            template: path.resolve(__dirname, "../../../../src/main/resources", "index.html")
        })*/
    ]
};
