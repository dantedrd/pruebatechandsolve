import React from "react";
import ReactLoading from "react-loading";

const LoadingContainer = ({ open, children, className }) => (
  <section className={(open === true && "loading " + className) || className}>
    {children}
    {open === true && (
      <span className="loading-center">
        <ReactLoading type="bars" color="#cecece" height={95} width={140} />
      </span>
    )}
  </section>
);

export const Loading = ({ open }) => (
  <div
    className={(open === true && "bg-modal fade") || ""}
    style={(open === true && { display: "block", opacity: 1 }) || {}}
  >
    <div className="loading-center">
      <ReactLoading type="bars" color="#cecece" height={95} width={140} open />
    </div>
  </div>
);

export default LoadingContainer;